package com.example.restaruant_reservation.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.Red
import com.example.restaruant_reservation.ui.theme.RedCard


@Preview
@Composable
fun PreviewConfirmReservation() {
    ReserveBottomSheet(navController = rememberNavController())
}

@Composable
fun ReserveBottomSheet(navController: NavController) {
    val addressrestaurantname = "Ann BBQ Su Van Hanh. \nNo 716 Su Van Hanh, Ward 12, Dist 10, HCM"
    val sana = "Wednesday, 25th Sep 2021"
    val vaqt = "18h00 - 18h30"
    val people = "2 People"
    val notes = "Window Seats"
    val name = "Sardor ibn Mustafo"
    val number = "90 324 75 72"
    val gmail = "@Abdulloh.ibn.Mustafo"

    val dialogOpen = remember {
        mutableStateOf(false)
    }


    Column(
        Modifier
            .background(
                Color.White,
                RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.location_icon),
                contentDescription = "manzil",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = addressrestaurantname)
        }
        Spacer(
            modifier = Modifier
                .width(12.dp)
                .height(12.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.calendar_icon),
                contentDescription = "sana",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = sana)

        }
        Spacer(
            modifier = Modifier
                .width(12.dp)
                .height(12.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.clock_icon),
                contentDescription = "vatq",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = vaqt)

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.people_icon),
                contentDescription = "people",
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = people)

        }
        Spacer(modifier = Modifier.height(24.dp))

        Card(colors = CardDefaults.cardColors(Color.White)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.person_img), contentDescription = "",
                    Modifier
                        .clip(
                            CircleShape
                        )
                        .size(60.dp), contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = name)
                    Text(text = number)
                    Text(text = gmail)
                }

            }


        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.pencil_icon),
                contentDescription = "notes ",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                tint = Color.Red
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = notes)

        }

        Spacer(modifier = Modifier.height(10.dp))
        Card(colors = CardDefaults.cardColors(Color.White)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.credit_card),
                    contentDescription = "",
                    tint = RedCard,
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Column {
                    Text(text = "Your deposit is 200.000VND")
                    Text(text = "Please pay within 30 minutes. If not, your reservation will be canceled automatically.")

                }


            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                dialogOpen.value = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),

            colors = ButtonDefaults.buttonColors(Red),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "CONFIRM", fontSize = 18.sp)
        }


    }
    if (dialogOpen.value) AlertDialog(
        onDismissRequest = { },
        buttons = {
            TextButton(
                onClick = {
                    dialogOpen.value = false
                    navController.popBackStack() },
                shape = RoundedCornerShape(8.dp),
                modifier =
                Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) { Text(text = "OK") }
        },
        text = {
            Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
                Icon(
                    painter = painterResource(id = R.drawable.check_icon),
                    contentDescription = "",
                    tint = Color.Green,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(130.dp)
                )
            }
        })
}
