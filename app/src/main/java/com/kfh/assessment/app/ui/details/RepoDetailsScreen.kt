package com.kfh.assessment.app.ui.details
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kfh.assessment.app.R
import com.kfh.assessment.app.di.ServiceLocator
import com.kfh.assessment.app.ui.common.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RepoDetailsScreen(workspace: String, slug: String) {
  val ctx = androidx.compose.ui.platform.LocalContext.current
  val vm = remember { DetailsViewModel(ServiceLocator.getRepoDetails(ctx)) }
  val state by vm.state.collectAsState()
  var refreshing by remember { mutableStateOf(false) }
  val swipeState = rememberSwipeRefreshState(isRefreshing = refreshing)
  LaunchedEffect(workspace, slug) { if (workspace.isNotBlank() && slug.isNotBlank()) vm.load(workspace, slug, force = false) }

  SwipeRefresh(state = swipeState, onRefresh = {
    refreshing = true
    vm.load(workspace, slug, force = true)
    refreshing = false
  }) {
    when (val s = state) {
      is UiState.Loading -> CenteredLoading()
      is UiState.Error -> CenteredMessage(textRes = R.string.no_repos)
      is UiState.Success -> {
        val r = s.data
        Column(Modifier.fillMaxWidth().padding(16.dp)) {
          AppTextRes(R.string.text_plain, r.name)
          Spacer(Modifier.height(8.dp))
          AppTextRes(R.string.full_name, r.fullName)
          AppTextRes(R.string.slug, r.slug)
          AppTextRes(R.string.privatedata, (r.isPrivate ?: false).toString())
          AppTextRes(R.string.scm, r.scm ?: "—")
          AppTextRes(R.string.language, r.language ?: "—")
          AppTextRes(R.string.size, r.size ?: 0)
          AppTextRes(R.string.main_branch, r.mainBranch ?: "—")
          AppTextRes(R.string.owner, r.ownerDisplayName ?: "—")
          AppTextRes(R.string.created_on, r.createdOn ?: "—")
          AppTextRes(R.string.updated_on, r.updatedOn ?: "—")
          Spacer(Modifier.height(8.dp))
          AppTextRes(R.string.web, r.htmlUrl ?: "—")
          Spacer(Modifier.height(16.dp))
          AppTextRes(R.string.text_plain, r.description ?: "—")
        }
      }
    }
  }
}
