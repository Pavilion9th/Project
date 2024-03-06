package com.example.restaruant_reservation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.screens.ReserveBottomSheet
import com.example.restaruant_reservation.screens.ReservationScreen
import com.example.restaruant_reservation.screens.bestSeller
import com.example.restaruant_reservation.screens.first
import com.example.restaruant_reservation.screens.forgotPassword1
import com.example.restaruant_reservation.screens.happyDeals
import com.example.restaruant_reservation.screens.login
import com.example.restaruant_reservation.screens.notifications
import com.example.restaruant_reservation.screens.second
import com.example.restaruant_reservation.screens.signUp
import com.example.restaruant_reservation.screens.status
import com.example.restaruant_reservation.screens.third
import com.example.restaruant_reservation.ui.theme.Screens.homePage

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ConfirmReservation.route) {
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
        composable(route = Screens.ConfirmReservation.route) {
            ReserveBottomSheet(navController = navController)
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
        composable(route = Screens.BestSeller.route) {
            bestSeller(navController = navController)
        }
        composable(route = Screens.HappyDeals.route) {
            happyDeals(navController = navController)
        }
        composable(route = Screens.Notifications.route) {
            notifications(navController = navController)
        }
        composable(route = Screens.Status.route) {
            status(navController = navController)
        }
    }
}