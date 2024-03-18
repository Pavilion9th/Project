package com.example.restaruant_reservation.ui.theme.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.model.Food
import com.example.restaruant_reservation.navigation.Screens
import com.example.restaruant_reservation.ui.theme.BgColor
import com.example.restaruant_reservation.ui.theme.Brown
import com.example.restaruant_reservation.ui.theme.Gray
import com.example.restaruant_reservation.ui.theme.LinearDark2
import com.example.restaruant_reservation.ui.theme.LinearLight
import com.example.restaruant_reservation.ui.theme.LinearLight2
import com.example.restaruant_reservation.ui.theme.Pink10
import com.example.restaruant_reservation.ui.theme.Red2
import com.example.restaruant_reservation.ui.theme.White


//@Preview
//@Composable
//fun homePagePrev() {
//    homePage(navController = rememberNavController())
//}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun homePage(navController: NavController) {
    val fontFamily = FontFamily(Font(R.font.montserratbold))
    val bold = FontFamily(Font(R.font.montserratbolditalic))
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BgColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            Icon(imageVector = Icons.Default.List,
                contentDescription = "List",
                tint = Brown,
                modifier = Modifier
                    .clickable { navController.navigate(Screens.Status.route) }
                    .height(50.dp)
                    .width(50.dp)
                    .padding(10.dp))
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .height(35.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.location_icon),
                    contentDescription = "location",
                    modifier = Modifier
                        .width(23.dp)
                        .height(23.dp)
                )
                Text(
                    text = "There should", fontSize = 15.sp
                )

            }
            Icon(imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications",
                tint = Brown,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate(Screens.Notifications.route) })
        }
        SearchBar()
        Card(modifier = Modifier
            .width(330.dp)
            .clickable { navController.navigate(Screens.HappyDeals.route) }
            .height(150.dp),
            colors = CardDefaults.cardColors(containerColor = Pink10)) {
            Row(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .width(165.dp)
                        .height(150.dp)
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "logo",
                        modifier = Modifier.padding(10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.text),
                        contentDescription = "ads",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(100.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .width(165.dp)
                        .height(150.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.chicken_animation),
                        contentDescription = "cha",
                        modifier = Modifier.size(125.dp)
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "Best Seller", color = Brown, fontFamily = fontFamily, fontSize = 18.sp
            )
            Text(text = "See all >",
                color = Gray,
                fontFamily = bold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate(Screens.BestSeller.route) })
        }
        val list = listOf(
            Food("arancini", R.drawable.arancini, "Olmazor tumani"),
            Food("spaghetti", R.drawable.spagetti, "Chilonzor tumani"),
            Food("pizza", R.drawable.spagetti, "Yashnobod tumani"),
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(list.size) {
                Spacer(modifier = Modifier.width(6.dp))
                Card(
                    modifier = Modifier
                        .width(165.dp)
                        .padding(5.dp)
                        .height(222.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                    ) {
                        Image(
                            painter = painterResource(id = list[it].image),
                            contentDescription = "arancini",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Column(
                        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = list[it].name,
                            fontSize = 18.sp,
                            fontFamily = fontFamily,
                            color = Brown
                        )
                        Text(
                            text = list[it].location,
                            fontSize = 12.sp,
                            fontFamily = fontFamily,
                            color = Brown
                        )
                        TextButton(
                            onClick = {navController.navigate(Screens.Reservation.route)},
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 6.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.textButtonColors(
                                Red2
                            )
                        ) {
                            Text(text = "Reserve", color = Color.White)
                        }
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
            }


        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "Our restaurants", color = Brown, fontFamily = fontFamily, fontSize = 18.sp
            )
            Text(text = "See all >",
                color = Gray,
                fontFamily = bold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate(Screens.BestSeller.route) })
        }

        RestaurantBanner(navController)
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(
                text = "Happy Deals", color = Brown, fontFamily = fontFamily, fontSize = 18.sp
            )
            Text(text = "See all >",
                color = Gray,
                fontFamily = bold,
                fontSize = 14.sp,
                modifier = Modifier.clickable { navController.navigate(Screens.HappyDeals.route) })
        }
        RowHappyDeals(navController)

    }


}

@Composable
fun RowHappyDeals(navController: NavController) {
    Row(
        modifier = Modifier
            .padding(20.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .width(250.dp)
                .padding(end = 10.dp)
                .height(120.dp),
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.linear),
//                contentDescription = "linear",
//                modifier = Modifier.fillMaxSize()
//            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(LinearLight, LinearLight),
                            startX = 0.0f
                        ),
                        RoundedCornerShape(16.dp)
                    ),
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Text(
                    text = "LAAARGE DISCOUNTS",
                    color = White,
                    fontFamily = FontFamily(Font(R.font.montserratbold)),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(
                            text = "Upto 20% off\n No upper limit",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.montserratbold)),
                            color = White
                        )
                        Text(
                            text = "View them",
                            color = Color.Blue,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.montserratbolditalic)),
                            modifier = Modifier
                                .padding(start = 12.dp, top = 5.dp)
                                .clickable { navController.navigate(Screens.HappyDeals.route) }
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.happydealbannerphoto),
                        contentDescription = "zaplakannaya"
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .width(250.dp)
                .height(120.dp),
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.linear),
//                contentDescription = "linear",
//                modifier = Modifier.fillMaxSize()
//            )
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(LinearLight2, LinearDark2),
                            startX = 0.0f
                        ),
                        RoundedCornerShape(16.dp)
                    ),
                colors = CardDefaults.cardColors(Color.Transparent)
            ) {
                Text(
                    text = "TRY NEW DISHES",
                    color = White,
                    fontFamily = FontFamily(Font(R.font.montserratbold)),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.padding(8.dp)) {
                        Text(
                            text = "Explore unique taste\n" +
                                    "For new eateries",
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.montserratbold)),
                            color = White
                        )
                        Text(
                            text = "View them",
                            color = Color.Blue,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.montserratbolditalic)),
                            modifier = Modifier
                                .padding(start = 12.dp, top = 5.dp)
                                .clickable { navController.navigate(Screens.HappyDeals.route) }
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.happydealbannerphoto),
                        contentDescription = "zaplakannaya"
                    )
                }
            }
        }
    }
}

@Composable
fun RestaurantBanner(navController: NavController) {
    Column() {
        Card(
            modifier = Modifier
                .width(330.dp)
                .padding(bottom = 10.dp)
                .clickable { navController.navigate(Screens.ReservationScreen.route) }
                .height(185.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurantbannerbg),
                    contentDescription = "restaurantbannerbg",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row {
                Column(
                    modifier = Modifier
                        .width(250.dp)
                        .height(75.dp)
                        .padding(8.dp)

                ) {
                    Text(
                        text = "LPH Chilonzor",
                        color = Brown,
                        fontFamily = FontFamily(Font(R.font.montserratbold)),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Vincom Center, No. 70 Le Thanh Ton, Ben Nghe Ward, District 1, HCMC",
                        color = Brown,
                        fontFamily = FontFamily(Font(R.font.montserratbold)),
                        fontSize = 12.sp
                    )
                }
                Column(
                    Modifier
                        .width(70.dp)
                        .height(75.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.meat),
                        contentDescription = "meat",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .width(330.dp)
                .padding(bottom = 10.dp)
                .clickable { navController.navigate(Screens.ReservationScreen.route) }
                .height(185.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurantbannerbg2),
                    contentDescription = "restaurantbannerbg",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row {
                Column(
                    modifier = Modifier
                        .width(250.dp)
                        .height(75.dp)
                        .padding(8.dp)

                ) {
                    Text(
                        text = "LPH Yashnobod",
                        color = Brown,
                        fontFamily = FontFamily(Font(R.font.montserratbold)),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "No. 716 Su Van Hanh, Ward 12, District 10, HCMC",
                        color = Brown,
                        fontFamily = FontFamily(Font(R.font.montserratbold)),
                        fontSize = 12.sp
                    )
                }
                Column(
                    Modifier
                        .width(70.dp)
                        .height(75.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.meat),
                        contentDescription = "meat",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .width(330.dp)
                .clickable { navController.navigate(Screens.ReservationScreen.route) }
                .height(185.dp),
            colors = CardDefaults.cardColors(containerColor = White)
        ) {


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.restaurantbannerbg3),
                    contentDescription = "restaurantbannerbg",
                    modifier = Modifier.fillMaxSize()
                )
            }
            Row {
                Column(
                    modifier = Modifier
                        .width(250.dp)
                        .height(75.dp)
                        .padding(8.dp)

                ) {
                    Text(
                        text = "LPH Olmozor",
                        color = Brown,
                        fontFamily = FontFamily(Font(R.font.montserratbold)),
                        fontSize = 16.sp
                    )
                    Text(
                        text = "No. 235 Nguyen Van Cu, Nguyen Cu Trinh Ward, District 10, HCMC",
                        color = Brown,
                        fontFamily = FontFamily(Font(R.font.montserratbold)),
                        fontSize = 12.sp
                    )
                }
                Column(
                    Modifier
                        .width(70.dp)
                        .height(75.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.meat),
                        contentDescription = "meat",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        value = query,
        onValueChange = {
            query = it
        },
        modifier = Modifier
            .padding(16.dp)
            .width(327.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = "Search Icon", tint = Brown
            )
        },
        trailingIcon = {
            if (isSearchActive) {
                IconButton(onClick = {
                    query = ""
                    isSearchActive = false
                    keyboardController?.hide()
                }) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear Icon")
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            // Handle search action here
            keyboardController?.hide()
        }),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black, fontSize = 15.sp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            containerColor = Color.White,

            ),
        singleLine = true,
        shape = RoundedCornerShape(15.dp),
    )
}

