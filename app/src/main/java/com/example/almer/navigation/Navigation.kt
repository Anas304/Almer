package com.example.almer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.almer.screens.*

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.FirstScreen.route) {
        composable(Screens.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(Screens.MainScreen.route) {
            OverviewScreen(navController = navController)
        }
        composable(Screens.ConnectToAlmerScreen.route) {
            ConnectToAlmerGlass(navController = navController)
        }

        composable(Screens.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }

        composable(Screens.InformationScreen.route) {
            InformationScreen(navController = navController)
        }

        composable(Screens.AlmerGlassList.route) {
            AlmerGlassList(navController = navController)
        }
    }

}