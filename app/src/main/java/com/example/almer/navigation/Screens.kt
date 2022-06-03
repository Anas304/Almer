package com.example.almer.navigation

sealed class Screens(val route: String) {
    object FirstScreen : Screens("first_screen")
    object ConnectToAlmerScreen : Screens("connect_to_almer_screen")
    object MainScreen : Screens("main_screen")
    object SettingsScreen : Screens("settings_screen")
    object InformationScreen : Screens("information_screen")
}