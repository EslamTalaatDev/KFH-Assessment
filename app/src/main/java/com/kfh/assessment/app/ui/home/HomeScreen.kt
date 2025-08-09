package com.kfh.assessment.app.ui.home
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.kfh.assessment.app.di.ServiceLocator
import com.kfh.assessment.app.ui.common.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.kfh.assessment.app.R

@Composable
fun HomeScreen(nav: NavHostController) {
  val ctx = LocalContext.current
  val vm = remember { HomeViewModel(ServiceLocator.getRepos(ctx)) }
  val getUser = remember { ServiceLocator.getUser(ctx) }
  val state by vm.state.collectAsState()
  var workspace by remember { mutableStateOf("") }
  var refreshing by remember { mutableStateOf(false) }
  val swipeState = rememberSwipeRefreshState(isRefreshing = refreshing)

  LaunchedEffect(Unit) {
    runCatching { getUser() }.onSuccess { me ->
      if (me.uuid.isNotBlank()) { workspace = me.uuid; vm.load(workspace, force = false) }
    }
  }

  SwipeRefresh(state = swipeState, onRefresh = {
    if (workspace.isNotBlank()) {
      refreshing = true
      vm.load(workspace, force = true)
      refreshing = false
    }
  }) {
    when (val s = state) {
      is UiState.Loading -> CenteredLoading()
      is UiState.Error -> CenteredMessage(textRes = R.string.no_repos)
      is UiState.Success -> {
        val repos = s.data
        if (repos.isEmpty()) CenteredMessage(textRes = R.string.no_repos)
        else RepoList(repos) { r -> nav.navigate("repo/${workspace}/${r.slug}") }
      }
    }
  }
}
