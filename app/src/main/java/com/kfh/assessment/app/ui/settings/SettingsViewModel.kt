package com.kfh.assessment.app.ui.settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfh.assessment.app.ui.common.UiState
import com.kfh.assessment.domain.model.User
import com.kfh.assessment.domain.usecase.GetUserUseCase
import com.kfh.assessment.domain.usecase.LogoutUseCase
import com.kfh.assessment.data.store.CredStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SettingsViewModel(
  private val getUser: GetUserUseCase,
  private val logoutUseCase: LogoutUseCase,
  private val store: CredStore
): ViewModel() {
  private val _state = MutableStateFlow<UiState<User>>(UiState.Loading)
  val state: StateFlow<UiState<User>> = _state

  fun load(force: Boolean = false) {
    viewModelScope.launch {
      _state.value = if (force) UiState.Loading else _state.value
      runCatching { getUser(force) }
        .onSuccess { _state.value = UiState.Success(it) }
        .onFailure { _state.value = UiState.Error(it.message ?: "Failed to load user") }
    }
  }

  fun logout() = viewModelScope.launch {
    withContext(Dispatchers.IO) {
      logoutUseCase() // clears Room tables
      store.clear()   // clears creds -> App() shows login
    }
  }
}
