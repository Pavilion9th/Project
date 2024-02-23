package com.example.restaruant_reservation.ui.theme.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.TransparentWhite
import kotlinx.coroutines.launch

@Preview
@Composable
fun PreviewReservationScreen() {
    ReservationScreen(navController = rememberNavController())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReservationScreen(navController: NavController) {

    val tabData = listOf("Reservation", "Menu", "Reviews")
    val bodyPagerState = rememberPagerState(pageCount = {tabData.size})
    val coroutineScope = rememberCoroutineScope()
    val selectedIndex = mutableStateOf(0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(R.drawable.img_2),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(207.dp),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp)
                    .height(40.dp)
                    .width(40.dp)
                    .background(TransparentWhite, CircleShape)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = "back_icon",
                    tint = Color.White
                )
            }
            Column(modifier = Modifier.padding(top = 90.dp, start = 20.dp, end = 20.dp)) {
                Text(
                    text = "An BBQ Dong Khoi",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Vincom Center, No. 70 Le Thanh Ton, Bensd Nghe Ward, District 1, HCMC",
                    fontSize = 18.sp,
                    color = Color.White,
                )

                Text(
                    text = "Now Open - Closes at 10:00PM",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier
                    .padding(end = 16.dp, bottom = 24.dp)
                    .background(Color.Red, RoundedCornerShape(20.dp))
                    .align(Alignment.BottomEnd), verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "4.5",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 5.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Icon(Icons.Filled.Star, contentDescription = "", tint = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
            }


        }
        TabRow(selectedTabIndex = selectedIndex.value,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[selectedIndex.value]),
                    height = 3.dp,
                    color = Color(android.graphics.Color.parseColor("#FF2F7A83"))
                )
            },
            containerColor = Color.White
        ) {
            tabData.forEachIndexed { index, s ->
                Tab(selected = selectedIndex.value == index,
                    onClick = {
                        selectedIndex.value = index
                        coroutineScope.launch { bodyPagerState.animateScrollToPage(index) } },
                    text = {Text(text = s, color = Color.Black)}
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        repeat(5) {
            Text(
                text = "description",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            )
        }

    }

}
@Composable
fun Reservation(){
 
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()){
            Column {
                Row {
                    Icon(painter = painterResource(id = R.drawable.card_icon), contentDescription = "")
                    Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
                }
                Icon(painter = painterResource(id = R.drawable.card_icon), contentDescription = "")
                Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
            }

        }
    }

}

