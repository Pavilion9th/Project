package com.example.restaruant_reservation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.R


@Preview
@Composable
fun PreviewConfirmReservation() {
    ReserveBottomSheet(navController = rememberNavController())
}

@Composable
fun ReserveBottomSheet(navController: NavController) {
    val asdasd = "asdasdasdasd"
    val addressrestaurantname = "Ann BBQ Su Van Hanh. \nNo 716 Su Van Hanh, Ward 12, Dist 10, HCM"

    Column(
        Modifier
            .background(
                Color.White,
                RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .fillMaxWidth()
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
        Icon(painter = painterResource(id = R.drawable.location_icon), contentDescription ="manzil",modifier= Modifier
                .width(60.dp)
                .height(60.dp))
            Text(text = addressrestaurantname)
        }

        Row (verticalAlignment = Alignment.CenterVertically){
           Icon(painter = painterResource(id = R.drawable.calendar_icon), contentDescription ="manzil",modifier= Modifier
                .width(50.dp)
                .height(50.dp), tint = Color.Red)
            Text(text = addressrestaurantname)
        }

        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.img_1), contentDescription ="manzil",modifier= Modifier
                .width(60.dp)
                .height(60.dp))
            Text(text = addressrestaurantname)
        }

    }
}