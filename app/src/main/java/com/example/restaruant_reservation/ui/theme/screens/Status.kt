package com.example.restaruant_reservation.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.restaruant_reservation.ui.theme.Red2
import com.example.restaruant_reservation.ui.theme.RedText
import com.example.restaruant_reservation.ui.theme.White

@Composable
fun status(navController: NavController) {
    val fontFamily = FontFamily(Font(R.font.montserratbold))
    val bold = FontFamily(Font(R.font.montserratbolditalic))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BgColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(200.dp)
        )
        Card(colors = CardDefaults.cardColors(containerColor = Color.Transparent)) {
            Row {


                Column {
                    Image(
                        painter = painterResource(id = R.drawable.avatar),
                        contentDescription = "as",
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .size(100.dp)
                    )
                }
                Column {
                    Text(
                        modifier = Modifier.padding(start = 5.dp, top = 5.dp),
                        text = "Cristiano Dos Santos",
                        fontFamily = fontFamily,
                        fontSize = 24.sp,
                        color = Brown
                    )
                    Button(
                        modifier = Modifier.padding(top = 5.dp, start = 5.dp),
                        shape = RoundedCornerShape(10.dp),
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(containerColor = Red2)
                    ) {
                        Text(
                            text = "Edit profile",
                            fontFamily = fontFamily,
                            fontSize = 18.sp,
                            color = White
                        )
                    }
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(35.dp)
        )
        Card(
            modifier = Modifier
                .width(330.dp)
                .height(229.dp), colors = CardDefaults.cardColors(containerColor = BgColor),
            border = BorderStroke(1.dp, RedText),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(Modifier.fillMaxSize()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home_icon),
                        contentDescription = "home_icon",
                        Modifier
                            .padding(horizontal = 15.dp)
                            .size(22.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "Home", fontFamily = fontFamily,
                        fontSize = 16.sp,
                        color = RedText
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(RedText)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.reservation),
                        contentDescription = "reservation",
                        Modifier
                            .padding(horizontal = 15.dp)
                            .size(22.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "Reservation", fontFamily = fontFamily,
                        fontSize = 16.sp,
                        color = RedText
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(RedText)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.changepassword),
                        contentDescription = "changepassword",
                        Modifier
                            .padding(horizontal = 15.dp)
                            .size(22.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "Change Password", fontFamily = fontFamily,
                        fontSize = 16.sp,
                        color = RedText
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(RedText)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.aboutus),
                        contentDescription = "aboutus",
                        Modifier
                            .padding(horizontal = 15.dp)
                            .size(22.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "About us", fontFamily = fontFamily,
                        fontSize = 16.sp,
                        color = RedText
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(RedText)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = "logout",
                        Modifier
                            .padding(horizontal = 15.dp)
                            .size(22.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        text = "Log out", fontFamily = fontFamily,
                        fontSize = 16.sp,
                        color = RedText
                    )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(RedText)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), colors = CardDefaults.cardColors(containerColor = Color.Transparent) ){
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Golden Gate Trading Service Joint Stock Company" +
                        "Head office: No. 60 Pho Duc Chinh Street, \u2028Nguyen Thai Binh Ward, District 1, HCMC, Vietnam" +
                        "GPK: 0102721191 issued on 09/04/2008" +
                        "Tel: 043 222 3000" +
                        "Email: support@anbbq.com.vn",
                color = Brown,
                fontFamily = fontFamily,
                fontSize = 15.sp
            )
        }
    }
}