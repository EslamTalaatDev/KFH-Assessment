package com.kfh.assessment.data.net
import android.util.Base64
import com.kfh.assessment.data.api.BitbucketService
import com.kfh.assessment.data.store.CredStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object OkHttpRetrofit {
  private fun authInterceptor(store: CredStore) = Interceptor { chain ->
    val req = chain.request()
    val (u, p) = runBlocking { store.credentials.first() }
    val newReq = if (!u.isNullOrBlank() && !p.isNullOrBlank()) {
      val token = Base64.encodeToString("$u:$p".toByteArray(), Base64.NO_WRAP)
      req.newBuilder().addHeader("Authorization", "Basic $token").build()
    } else req
    chain.proceed(newReq)
  }

  private fun moshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

  fun service(store: CredStore): BitbucketService {
    val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder()
      .connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS)
      .certificatePinner(CertificatePinnerFactory.bitbucket())
      .addInterceptor(authInterceptor(store))
      .addInterceptor(logging)
      .build()
    return Retrofit.Builder()
      .baseUrl("https://api.bitbucket.org/")
      .addConverterFactory(MoshiConverterFactory.create(moshi()))
      .client(client).build().create(BitbucketService::class.java)
  }

  fun serviceWithBasic(user: String, pass: String): BitbucketService {
    val auth = Interceptor { chain ->
      val token = Base64.encodeToString("$user:$pass".toByteArray(), Base64.NO_WRAP)
      chain.proceed(chain.request().newBuilder().addHeader("Authorization", "Basic $token").build())
    }
    val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    val client = OkHttpClient.Builder()
      .connectTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS)
      .certificatePinner(CertificatePinnerFactory.bitbucket())
      .addInterceptor(auth).addInterceptor(logging).build()
    return Retrofit.Builder()
      .baseUrl("https://api.bitbucket.org/")
      .addConverterFactory(MoshiConverterFactory.create(moshi()))
      .client(client).build().create(BitbucketService::class.java)
  }
}
