package com.example.restaruant_reservation.ui.theme.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.navigation.Screens

@Composable
fun first(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.padding(bottom = 50.dp)) {

            Image(
                painter = painterResource(id = R.drawable.los),
                contentDescription = "Los Pollos Hermanos",
                modifier = Modifier
                    .size(65.dp)
                    .padding(vertical = 0.dp)
            )
            Text(
                text = "Welcome to Los \nPollos Hermanos", fontSize = 23.sp,
                modifier = Modifier.padding(vertical = 0.dp),
                fontFamily = FontFamily.Serif
            )

        }
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "locations",
            modifier = Modifier.size(240.dp)
        )

        Text(text = "Nearby Restaurants", fontSize = 21.sp, modifier = Modifier.padding(top = 10.dp))
        Text(
            text = "Don't have to go far to find a good restaurant",
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 20.dp)
        )
        Row(horizontalArrangement = Arrangement.SpaceBetween ,modifier = Modifier.fillMaxWidth().padding(top = 35.dp)) {
            Text(
                text = "Skip",
                fontFamily = FontFamily.Serif,
                modifier = Modifier.clickable { navController.navigate((Screens.Login.route)) })
            Row {


                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favorite")
            }
//            Image(
//                painter = painterResource(id = R.drawable.dods1),
//                contentDescription = "something"
//            )
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "description", modifier = Modifier.clickable { navController.navigate((Screens.Second.route)) })
        }
    }
}