package com.kfh.assessment.app.ui.details
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kfh.assessment.app.ui.common.UiState
import com.kfh.assessment.domain.model.RepoDetail
import com.kfh.assessment.domain.usecase.GetRepoDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(private val getDetails: GetRepoDetailsUseCase): ViewModel() {
  private val _state = MutableStateFlow<UiState<RepoDetail>>(UiState.Loading)
  val state: StateFlow<UiState<RepoDetail>> = _state
  private var cached: RepoDetail? = null
  fun load(workspace: String, slug: String, force: Boolean = false) {
    if (!force && cached?.slug == slug) { _state.value = UiState.Success(cached!!); return }
    viewModelScope.launch {
      _state.value = UiState.Loading
      runCatching { getDetails(workspace, slug, force) }
        .onSuccess { cached = it; _state.value = UiState.Success(it) }
        .onFailure { _state.value = UiState.Error(it.message ?: "Failed to load repository") }
    }
  }
  fun clearCache() { cached = null }
}
