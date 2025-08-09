package com.kfh.assessment.app.ui.login
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfh.assessment.app.ui.common.UiState
import com.kfh.assessment.data.net.OkHttpRetrofit
import com.kfh.assessment.data.store.CredStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel(
  private val store: CredStore,
  private val validator: suspend (String, String) -> Unit = { user, pass ->
    val svc = OkHttpRetrofit.serviceWithBasic(user, pass)
    withContext(Dispatchers.IO) { svc.getMe() }
  }
): ViewModel() {
  private val _state = MutableStateFlow<UiState<Unit>>(UiState.Success(Unit))
  val state: StateFlow<UiState<Unit>> = _state

  fun login(user: String, pass: String) {
    _state.value = UiState.Loading
    viewModelScope.launch {
      try {
        validator(user, pass)
        store.save(user, pass)
        _state.value = UiState.Success(Unit)
      } catch (t: Throwable) {
        val err = toAuthError(t)
        _state.value = UiState.Error(err.code.name + (err.httpCode?.let { " $it" } ?: ""))
      }
    }
  }

  private fun toAuthError(t: Throwable): AuthException = when (t) {
    is HttpException -> when (t.code()) {
      401 -> AuthException(AuthErrorCode.INVALID, 401)
      403 -> AuthException(AuthErrorCode.FORBIDDEN, 403)
      else -> AuthException(AuthErrorCode.HTTP, t.code())
    }
    is IOException -> AuthException(AuthErrorCode.NETWORK, null, t.message)
    else -> AuthException(AuthErrorCode.UNKNOWN, null, t.message)
  }
}
