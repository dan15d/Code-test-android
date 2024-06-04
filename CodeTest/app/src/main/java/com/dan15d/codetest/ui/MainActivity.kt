package com.dan15d.codetest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dan15d.codetest.domain.model.User
import com.dan15d.codetest.ui.theme.CodeTestTheme
import com.dan15d.codetest.ui.screens.user_detail.UserDetail
import com.dan15d.codetest.ui.screens.user_list.UserList
import com.dan15d.codetest.utils.StringUtils
import kotlinx.serialization.json.Json

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CodeTestTheme {
                val navController = rememberNavController()
                NavigationGraph(navController)
            }
        }
    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = "list"
        ) {
            composable("list") {
                UserList(navController = navController)
            }

            composable("detail/{user}") { navBackStackEntry ->
                val userJson = StringUtils.fromUTF8Base64(navBackStackEntry.arguments?.getString("user")!!)
                val userObject = Json.decodeFromString<User>(userJson.replace("%40", "@"))
                UserDetail(user = userObject, navController = navController)
            }

        }
    }
}