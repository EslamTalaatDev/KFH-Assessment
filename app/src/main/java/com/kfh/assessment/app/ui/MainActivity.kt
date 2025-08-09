package com.kfh.assessment.app.ui
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.kfh.assessment.app.R
import com.kfh.assessment.app.di.ServiceLocator
import com.kfh.assessment.app.ui.common.AppTextRes
import com.kfh.assessment.app.ui.details.RepoDetailsScreen
import com.kfh.assessment.app.ui.home.HomeScreen
import com.kfh.assessment.app.ui.login.AuthScreen
import com.kfh.assessment.app.ui.settings.SettingsScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { App() }
  }
}

@Composable fun App() {
  val ctx = androidx.compose.ui.platform.LocalContext.current
  val cred = remember { ServiceLocator.cred(ctx) }
  val creds by cred.credentials.collectAsState(initial = null to null)
  val isLoggedIn = !creds.first.isNullOrBlank() && !creds.second.isNullOrBlank()
  if (!isLoggedIn) AuthScreen() else Tabs()
}

@Composable fun Tabs() {
  val nav = rememberNavController()
  val items = listOf("home", "settings")
  Scaffold(bottomBar = {
    NavigationBar {
      val dest = nav.currentBackStackEntryAsState().value?.destination
      items.forEach { r ->
        NavigationBarItem(
          selected = dest?.route == r,
          onClick = { nav.navigate(r) {
            popUpTo(nav.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true; restoreState = true } },
          label = { AppTextRes(if (r=="home") R.string.tab_home else R.string.tab_settings) },
          icon = { if (r=="home") Icon(Icons.Default.Home, null) else Icon(Icons.Default.Settings, null) }
        )
      }
    }
  }) { pad ->
    NavHost(nav, "home", Modifier.padding(pad)) {
      composable("home") { HomeScreen(nav) }
      composable("settings") { SettingsScreen() }
      composable("repo/{workspace}/{slug}") { backStackEntry ->
        val workspace = backStackEntry.arguments?.getString("workspace") ?: ""
        val slug = backStackEntry.arguments?.getString("slug") ?: ""
        RepoDetailsScreen(workspace, slug)
      }
    }
  }
}
