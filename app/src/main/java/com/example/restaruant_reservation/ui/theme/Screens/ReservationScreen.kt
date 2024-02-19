package com.example.restaruant_reservation.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.restaruant_reservation.R

@Composable
 fun ReservationScreen(navController: NavController){
  Column(modifier = Modifier.fillMaxSize()) {
      Image(painterResource(R.drawable.img), contentDescription ="" )
  }
 }