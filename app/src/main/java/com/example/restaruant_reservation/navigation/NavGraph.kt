package com.example.restaruant_reservation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.Screens.aboutUs
import com.example.restaruant_reservation.Screens.changePassword
import com.example.restaruant_reservation.Screens.reservationHistory
import com.example.restaruant_reservation.Screens.restaurantInfo
import com.example.restaruant_reservation.Screens.status
import com.example.restaruant_reservation.ui.theme.screens.homePage
import com.example.restaruant_reservation.ui.theme.screens.ReservationScreen
import com.example.restaruant_reservation.ui.theme.screens.ReserveBottomSheet
import com.example.restaruant_reservation.ui.theme.screens.bestSeller
import com.example.restaruant_reservation.ui.theme.screens.first
import com.example.restaruant_reservation.ui.theme.screens.forgotPassword1
import com.example.restaruant_reservation.ui.theme.screens.happyDeals
import com.example.restaruant_reservation.ui.theme.screens.login
import com.example.restaruant_reservation.ui.theme.screens.notifications
import com.example.restaruant_reservation.ui.theme.screens.second
import com.example.restaruant_reservation.ui.theme.screens.signUp
import com.example.restaruant_reservation.ui.theme.screens.third

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.First.route) {
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
        composable(route = Screens.ReservationScreen.route) {
            ReservationScreen(navController = navController)
        }
        composable(route = Screens.ReserveScreen.route) {
            ReserveBottomSheet(navController = navController)
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
        composable(route = Screens.AboutUs.route) {
            aboutUs(navController = navController)
        }
        composable(route = Screens.RestaurantInfo.route) {
            restaurantInfo(navController = navController)
        }
        composable(route = Screens.ChangePassword.route) {
            changePassword(navController = navController)
        }
        composable(route = Screens.ReservationHistory.route) {
            reservationHistory(navController = navController)
        }
        composable(route = Screens.RestaurantInfo.route) {
            restaurantInfo(navController = navController)
        }
    }
}


