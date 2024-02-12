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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.BgColor
import com.example.restaruant_reservation.ui.theme.Brown
import com.example.restaruant_reservation.ui.theme.navigation.Screens

@Composable
fun second(navController: NavController) {
    val fontFamily = FontFamily(Font(R.font.montserratbold))
    val bold = FontFamily(Font(R.font.montserratbolditalic))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BgColor)
            .verticalScroll(rememberScrollState()),
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
                fontFamily = bold,
                color = Brown
            )

        }
        Image(
            painter = painterResource(id = R.drawable.img2),
            contentDescription = "telephone",
            modifier = Modifier.size(240.dp)
        )

        Text(
            text = "Convenient",
            fontSize = 21.sp,
            modifier = Modifier.padding(top = 10.dp),
            fontFamily = fontFamily,
            color = Brown
        )
        Text(
            text = "Online dish reservation",
            fontSize = 16.sp,
            fontFamily = fontFamily,
            color = Brown,
            modifier = Modifier.padding(top = 20.dp, bottom = 80.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp, vertical = 45.dp)
        ) {
            Text(
                text = "Skip",
                fontFamily = fontFamily,
                color = Brown,
                modifier = Modifier.clickable { navController.navigate((Screens.Login.route)) })
            Row {

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Brown
                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Brown
                )

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Brown
                )
            }
//            Image(
//                painter = painterResource(id = R.drawable.dods1),
//                contentDescription = "something"
//            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "description",
                tint = Brown,
                modifier = Modifier.clickable { navController.navigate((Screens.Third.route)) })
        }
    }
}