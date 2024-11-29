package com.isodev.personalaibuddyui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isodev.personalaibuddyui.ui.screen.MainScreen
import com.isodev.personalaibuddyui.ui.screen.SecondScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen {
                navController.navigate("second")
            }
        }
        composable("second") {
            SecondScreen()
        }
    }
}