package com.kfh.assessment.app.di
import android.content.Context
import androidx.room.Room
import com.kfh.assessment.data.db.AppDb
import com.kfh.assessment.data.net.OkHttpRetrofit
import com.kfh.assessment.data.repo.BitbucketRepositoryImpl
import com.kfh.assessment.data.store.CredStore
import com.kfh.assessment.domain.repo.BitbucketRepository
import com.kfh.assessment.domain.usecase.*

object ServiceLocator {
  @Volatile private var dbInst: AppDb? = null
  @Volatile private var storeInst: CredStore? = null
  @Volatile private var repoInst: BitbucketRepository? = null

  fun db(ctx: Context): AppDb =
    dbInst ?: synchronized(this) {
      dbInst ?: Room.databaseBuilder(ctx.applicationContext, AppDb::class.java, "kfh-assessment.db")
        .fallbackToDestructiveMigration()
        .build().also { dbInst = it }
    }

  fun cred(ctx: Context): CredStore =
    storeInst ?: synchronized(this) {
      storeInst ?: CredStore(ctx.applicationContext).also { storeInst = it }
    }

  fun repo(ctx: Context): BitbucketRepository =
    repoInst ?: synchronized(this) {
      repoInst ?: BitbucketRepositoryImpl(OkHttpRetrofit.service(cred(ctx)), db(ctx)).also { repoInst = it }
    }

  fun getRepos(ctx: Context) = GetReposUseCase(repo(ctx))
  fun getRepoDetails(ctx: Context) = GetRepoDetailsUseCase(repo(ctx))
  fun getUser(ctx: Context) = GetUserUseCase(repo(ctx))
  fun logout(ctx: Context) = LogoutUseCase(repo(ctx))
}
