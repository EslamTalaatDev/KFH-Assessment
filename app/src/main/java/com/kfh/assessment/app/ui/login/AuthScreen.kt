package com.kfh.assessment.app.ui.login
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.kfh.assessment.app.R
import com.kfh.assessment.app.di.ServiceLocator
import com.kfh.assessment.app.ui.common.*

@Composable
fun AuthScreen() {
  val ctx = LocalContext.current
  val vm = remember { LoginViewModel(ServiceLocator.cred(ctx)) }
  val state by vm.state.collectAsState()

  var user by remember { mutableStateOf("") }
  var pass by remember { mutableStateOf("") }

  Surface(Modifier.fillMaxSize()) {
    Column(Modifier.padding(24.dp)) {
      AppTextRes(R.string.login_title)
      Spacer(Modifier.height(16.dp))
      OutlinedTextField(value = user, onValueChange = { user = it }, label = { AppTextRes(R.string.username_or_email) }, singleLine = true)
      Spacer(Modifier.height(8.dp))
      OutlinedTextField(value = pass, onValueChange = { pass = it }, label = { AppTextRes(R.string.app_password_or_token) }, visualTransformation = PasswordVisualTransformation(), singleLine = true)
      Spacer(Modifier.height(16.dp))

      val isLoading = state is UiState.Loading
      AppButton(textRes = if (isLoading) R.string.signing_in else R.string.login, enabled = user.isNotBlank() && pass.isNotBlank(), loading = isLoading) {
        vm.login(user.trim(), pass)
      }

      if (state is UiState.Error) {
        Spacer(Modifier.height(8.dp))
        val msg = (state as UiState.Error).message
        val code = when {
          msg.startsWith(AuthErrorCode.INVALID.name) -> AuthErrorCode.INVALID
          msg.startsWith(AuthErrorCode.FORBIDDEN.name) -> AuthErrorCode.FORBIDDEN
          msg.startsWith(AuthErrorCode.NETWORK.name) -> AuthErrorCode.NETWORK
          msg.startsWith(AuthErrorCode.HTTP.name) -> AuthErrorCode.HTTP
          else -> AuthErrorCode.UNKNOWN
        }
        when (code) {
          AuthErrorCode.INVALID -> AppTextRes(R.string.invalid_credentials)
          AuthErrorCode.FORBIDDEN -> AppTextRes(R.string.forbidden_scopes)
          AuthErrorCode.NETWORK -> AppTextRes(R.string.network_error)
          AuthErrorCode.HTTP -> {
            val http = msg.substringAfter(' ', "400").toIntOrNull() ?: 400
            AppTextRes(R.string.login_failed_http, http)
          }
          AuthErrorCode.UNKNOWN -> AppTextRes(R.string.unexpected_error, msg)
        }
      }
    }
  }
}
