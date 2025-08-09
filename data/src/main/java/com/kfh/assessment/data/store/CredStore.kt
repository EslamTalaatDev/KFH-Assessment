package com.kfh.assessment.data.store
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
private val Context.dataStore by preferencesDataStore("creds")
class CredStore(private val context: Context) {
  private val KEY_USER = stringPreferencesKey("bb_user")
  private val KEY_PASS = stringPreferencesKey("bb_pass")
  val credentials: Flow<Pair<String?, String?>> = context.dataStore.data.map { it[KEY_USER] to it[KEY_PASS] }
  suspend fun save(user: String, pass: String) { context.dataStore.edit { it[KEY_USER] = user; it[KEY_PASS] = pass } }
  suspend fun clear() { context.dataStore.edit { it.clear() } }
}
