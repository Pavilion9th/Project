package com.example.restaruant_reservation.navigation

const val NAME_KEY ="name_key"
sealed class Screens(val route: String){
    object HomePage: Screens("home")
    object First: Screens("first")
    object Second: Screens("second")
    object Third: Screens("third")
    object Reservation: Screens("reservation")
    object ConfirmReservation: Screens("confirmReservation")
    object DepositNotification: Screens("depositNotification")
    object Menu: Screens("menu")
    object Reviews: Screens("reviews")
    object HappyDeals: Screens("happyDeals")
    object HappyDealsDetails: Screens("happyDealsDetails")
    object Notifications: Screens("notifications")
    object BestSeller: Screens("bestSeller")
    object Restaurants: Screens("restaurants")
    object Login: Screens("login")
    object SignUp: Screens("signUp")
    object ForgotPassword1: Screens("forgotPassword1")
    object ForgotPassword2: Screens("forgotPassword2")
    object ForgotPassword3: Screens("forgotPassword3")
    object ForgotPassword4: Screens("forgotPassword4")
    object Status: Screens("status")
    object Profile: Screens("profile")
    object ReservationHistory: Screens("reservationHistory")
    object ReviewsForm: Screens("reviewsForm")
    object ReservationInDetails: Screens("reservationInDetails")
    object ChangePassword: Screens("changePassword")

}