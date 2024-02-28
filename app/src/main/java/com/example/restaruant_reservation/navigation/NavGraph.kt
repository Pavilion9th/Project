package com.example.restaruant_reservation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.Screens.ReservationScreen
import com.example.restaruant_reservation.Screens.first
import com.example.restaruant_reservation.Screens.forgotPassword1
import com.example.restaruant_reservation.Screens.login
import com.example.restaruant_reservation.Screens.second
import com.example.restaruant_reservation.Screens.signUp
import com.example.restaruant_reservation.Screens.third
import com.example.restaruant_reservation.ui.theme.Screens.homePage

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Reservation.route) {
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
        composable(route = Screens.Reservation.route) {
            ReservationScreen(navController = navController)
        }
    }
}