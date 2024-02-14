package com.example.restaruant_reservation.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.ui.theme.Screens.first
import com.example.restaruant_reservation.ui.theme.Screens.forgotPassword1
import com.example.restaruant_reservation.ui.theme.Screens.homePage
import com.example.restaruant_reservation.ui.theme.Screens.login
import com.example.restaruant_reservation.ui.theme.Screens.second
import com.example.restaruant_reservation.ui.theme.Screens.signUp
import com.example.restaruant_reservation.ui.theme.Screens.third

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.HomePage.route) {
        composable(route = Screens.First.route) {
            first(navController = navController)
        }

        composable(route = Screens.Second.route) {
            second(navController = navController)
        }
        composable(route = Screens.Third.route) {
            third(navController = navController)
        }
        composable(route = Screens.Login.route) {
            login(navController = navController)
        }
        composable(route = Screens.HomePage.route) {
            homePage(navController = navController)
        }
        composable(route = Screens.ForgotPassword1.route) {
            forgotPassword1(navController = navController)
        }
        composable(route = Screens.SignUp.route) {
            signUp(navController = navController)
        }
    }
}