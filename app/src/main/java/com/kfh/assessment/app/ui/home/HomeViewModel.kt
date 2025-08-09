package com.kfh.assessment.app.ui.home
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfh.assessment.app.ui.common.UiState
import com.kfh.assessment.domain.model.Repo
import com.kfh.assessment.domain.usecase.GetReposUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getRepos: GetReposUseCase) : ViewModel() {
  private val _state = MutableStateFlow<UiState<List<Repo>>>(UiState.Loading)
  val state: StateFlow<UiState<List<Repo>>> = _state

  fun load(workspace: String, force: Boolean = false) {
    viewModelScope.launch {
      _state.value = if (force) UiState.Loading else _state.value
      runCatching { getRepos(workspace, "member", 100, force) }
        .onSuccess { _state.value = UiState.Success(it) }
        .onFailure { _state.value = UiState.Error(it.message ?: "load failed") }
    }
  }
}
