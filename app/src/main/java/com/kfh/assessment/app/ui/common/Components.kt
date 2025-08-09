package com.kfh.assessment.app.ui.common
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kfh.assessment.domain.model.Repo

@Composable
fun AppTextRes(@StringRes textRes: Int, vararg args: Any) {
  Text(stringResource(textRes, *args))
}

@Composable
fun CenteredLoading() {
  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
}

@Composable
fun CenteredMessage(@StringRes textRes: Int) {
  Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { AppTextRes(textRes) }
}

@Composable
fun AppButton(@StringRes textRes: Int, enabled: Boolean = true, loading: Boolean = false, onClick: () -> Unit) {
  Button(onClick = onClick, enabled = enabled && !loading) {
    if (loading) { CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp); Spacer(Modifier.width(8.dp)) }
    AppTextRes(textRes)
  }
}

@Composable
fun RepoList(repos: List<Repo>, onClick: (Repo) -> Unit) {
  LazyColumn(Modifier.fillMaxSize().padding(16.dp)) {
    items(repos, key = { it.uuid }) { r ->
      ElevatedCard(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).clickable { onClick(r) }
      ) {
        ListItem(
          headlineContent = { Text(r.name) },
          supportingContent = { Text(r.fullName) }
        )
      }
    }
  }
}
