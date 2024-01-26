package com.example.restaruant_reservation.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.ui.theme.Screens.first

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.First.route) {
        composable(route = Screens.First.route) {
            first(navController = navController)
        }

        composable(route = Screens.Second.route) {
            first(navController = navController)
        }

        composable(route = Screens.HomePage.route) {
            first(navController = navController)
        }
        composable(route = Screens.Third.route) {
            first(navController = navController)
        }
        composable(route = Screens.Login.route) {
            first(navController = navController)
        }
        composable(route = Screens.SignUp.route) {
            first(navController = navController)
        }
        
    }
}