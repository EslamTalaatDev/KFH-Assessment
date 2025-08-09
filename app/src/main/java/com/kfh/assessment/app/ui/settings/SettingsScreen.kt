package com.kfh.assessment.app.ui.settings
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.kfh.assessment.app.R
import com.kfh.assessment.app.di.ServiceLocator
import com.kfh.assessment.app.ui.common.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
  val ctx = LocalContext.current
  val vm = remember { SettingsViewModel(ServiceLocator.getUser(ctx), ServiceLocator.logout(ctx), ServiceLocator.cred(ctx)) }
  val state by vm.state.collectAsState()
  var refreshing by remember { mutableStateOf(false) }
  val swipeState = rememberSwipeRefreshState(isRefreshing = refreshing)

  LaunchedEffect(Unit) { vm.load(false) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { AppTextRes(R.string.settings_title) },
        actions = { TextButton(onClick = { vm.logout() }) { AppTextRes(R.string.logout) } }
      )
    }
  ) { pad ->
    SwipeRefresh(state = swipeState, onRefresh = {
      refreshing = true
      vm.load(true)
      refreshing = false
    }) {
      when (val s = state) {
        is UiState.Loading -> CenteredLoading()
        is UiState.Error -> CenteredMessage(textRes = R.string.unexpected_error)
        is UiState.Success -> {
          val u = s.data
          val rowsList = listOf(
            R.string.user_uuid to (u.uuid),
            R.string.user_username to (u.username ?: "—"),
            R.string.user_display_name to (u.displayName ?: "—"),
            R.string.user_account_id to (u.accountId ?: "—"),
            R.string.user_nickname to (u.nickname ?: "—"),
            R.string.user_status to (u.accountStatus ?: "—"),
            R.string.user_location to (u.location ?: "—"),
            R.string.user_created_on to (u.createdOn ?: "—"),
            R.string.user_2fa to ((u.has2FA ?: false).toString()),
            R.string.user_html to (u.htmlUrl ?: "—"),
            R.string.user_avatar to (u.avatarUrl ?: "—"),
            R.string.user_repos to (u.reposUrl ?: "—"),
            R.string.user_snippets to (u.snippetsUrl ?: "—")
          )
          LazyColumn(Modifier.padding(pad)) {
            items(rowsList) { (label, value) ->
              ListItem(headlineContent = { AppTextRes(label, value) })
              Divider()
            }
          }
        }
      }
    }
  }
}
