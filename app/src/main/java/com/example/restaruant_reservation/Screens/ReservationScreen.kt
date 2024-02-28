package com.example.restaruant_reservation.Screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.BlueLight
import com.example.restaruant_reservation.ui.theme.Red1
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.example.restaruant_reservation.ui.theme.RedCard
import com.example.restaruant_reservation.ui.theme.TextColor
import com.example.restaruant_reservation.ui.theme.TransparentWhite
import com.example.restaruant_reservation.ui.theme.White
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Preview
@Composable
fun PreviewReservationScreen() {
    ReservationScreen(navController = rememberNavController())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReservationScreen(navController: NavController) {
    val fontFamily = FontFamily(Font(R.font.montserratbold))
    val bold = FontFamily(Font(R.font.montserratbolditalic))
    val tabData = listOf("Reservation", "Menu", "Reviews")
    val bodyPagerState = rememberPagerState(pageCount = { tabData.size })
    val coroutineScope = rememberCoroutineScope()
    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
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
        TabRow(
            selectedTabIndex = selectedIndex.value,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(it[selectedIndex.value]),
                    height = 3.dp,
                    color = Color(android.graphics.Color.parseColor("#FF2F7A83"))
                )
                Log.d("SelectedIndex", "ReservationScreen: ${selectedIndex.value}")
            },
            containerColor = Color.White
        ) {
            tabData.forEachIndexed { index, s ->
                Tab(selected = selectedIndex.value == index,
                    onClick = {
                        selectedIndex.value = index
                        coroutineScope.launch { bodyPagerState.animateScrollToPage(index) }
                    },
                    text = { Text(text = s, color = Color.Black) }
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        when (selectedIndex.value) {
            0 -> {
                Reservation()
            }

            1 -> {
                Menu()
            }

            2 -> {
                Reviews()
            }
        }
//        repeat(5) {
//            Text(
//                text = "description",
//                style = MaterialTheme.typography.bodyMedium,
//                textAlign = TextAlign.Justify,
//                modifier = Modifier
//                    .background(Color.White)
//                    .padding(16.dp)
//            )
//        }

    }

}

@Composable
fun Reservation() {
    val context = LocalContext.current
    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }
    var StartTime by remember {
        mutableStateOf(LocalTime.NOON)
    }
    var EndTime by remember {
        mutableStateOf(LocalTime.NOON)
    }
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MM/dd/yyyy")
                .format(pickedDate)
        }
    }
    val formattedStartTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(StartTime)
        }
    }
    val formattedEndTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(EndTime)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val StartTimeDialogState = rememberMaterialDialogState()
    val EndTimeDialogState = rememberMaterialDialogState()
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.card_icon),
                        contentDescription = "",
                        tint = RedCard,
                        modifier = Modifier
                            .padding(6.dp)
                            .size(36.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.credit_card),
                        contentDescription = "",
                        tint = RedCard,
                        modifier = Modifier
                            .padding(6.dp)
                            .size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 5.dp)) {

                        Spacer(modifier = Modifier.width(8.dp))
                    Card(colors = CardDefaults.cardColors(containerColor = Red1)) {
                        Text(
                            modifier = Modifier
                                .clickable { dateDialogState.show() }
                                .padding(4.dp),
                            text = "Pick your date",
                            color = White,
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.montserratbold)),
                        )}
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        modifier = Modifier.clickable { dateDialogState.show() },
                        text = formattedDate,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }


                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Card(colors = CardDefaults.cardColors(containerColor = Red1)) {

                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = "Pick your time",
                        fontSize = 20.sp,
                        color = White,
                        fontFamily = FontFamily(Font(R.font.montserratbold))
                    ) }
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        modifier = Modifier.clickable { StartTimeDialogState.show() },
                        text = formattedStartTime,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.montserratbold))
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        modifier = Modifier.clickable { EndTimeDialogState.show() },
                        text = formattedEndTime,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.montserratbold))

                    )

                }
                MaterialDialog(
                    dialogState = dateDialogState,
                    buttons = {
                        positiveButton(text = "Ok") {
                            Toast.makeText(
                                context,
                                "Clicked ok",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        negativeButton(text = "Cancel")
                    }
                ) {
                    datepicker(
                        initialDate = LocalDate.now(),
                        title = "Pick a date",
                        allowedDateValidator = {
                            it.dayOfMonth % 2 == 1
                        }
                    ) {
                        pickedDate = it
                    }
                }
                MaterialDialog(
                    dialogState = StartTimeDialogState,
                    buttons = {
                        positiveButton(text = "Ok") {
                            Toast.makeText(
                                context,
                                "Clicked ok",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        negativeButton(text = "Cancel")
                    }
                ) {
                    timepicker(
                        initialTime = LocalTime.NOON,
                        title = "Pick a time",
                        timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
                    ) {
                        StartTime = it
                    }
                }
                MaterialDialog(
                    dialogState = EndTimeDialogState,
                    buttons = {
                        positiveButton(text = "Ok") {
                            Toast.makeText(
                                context,
                                "Clicked ok",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                        negativeButton(text = "Cancel")
                    }
                ) {
                    timepicker(
                        initialTime = LocalTime.NOON,
                        title = "Pick a time",
                        timeRange = LocalTime.MIDNIGHT..LocalTime.NOON
                    ) {
                        EndTime = it
                    }
                }
            }

        }
    }
}

@Composable
fun Menu() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                Row {
//                    Icon(painter = painterResource(id = R.drawable.card_icon), contentDescription = "")
                    Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
                }
                Icon(
                    painter = painterResource(id = R.drawable.credit_card),
                    contentDescription = ""
                )
                Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
            }

        }
    }
}

@Composable
fun Reviews() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.card_icon),
                        contentDescription = ""
                    )
                    Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
                }
//                Icon(painter = painterResource(id = R.drawable.credit_card), contentDescription = "")
                Text(text = "Must have Vaccinated Card ", fontSize = 20.sp)
            }

        }
    }
}


