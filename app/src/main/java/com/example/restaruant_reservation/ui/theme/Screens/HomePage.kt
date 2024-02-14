package com.example.restaruant_reservation.ui.theme.Screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.ContentAlpha
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.BgColor
import com.example.restaruant_reservation.ui.theme.Brown
import com.example.restaruant_reservation.ui.theme.navigation.Screens
import com.google.android.material.search.SearchBar
import java.time.format.TextStyle

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun homePage(navController: NavController) {
    var text by remember{ mutableStateOf("")
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
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding()
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "List", tint = Brown,
                modifier = Modifier
                    .clickable { navController.navigate(Screens.Status.route) }
                    .height(50.dp)
                    .width(50.dp)
                    .padding(10.dp)
            )
            Row(modifier = Modifier
                .padding(top = 10.dp)
                .height(35.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "location",
                    modifier = Modifier
                        .width(23.dp)
                        .height(23.dp)
                )
                Text(
                    text = "There should",
                    fontSize = 15.sp
                )

            }
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications", tint = Brown,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .padding(10.dp)
                    .clickable { navController.navigate(Screens.Notifications.route) }
            )
        }
        SearchBar()
    }
}
@RequiresApi(Build.VERSION_CODES.O)
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
            .background(color= Color.White)
            .width(327.dp)
            .height(40.dp)
        ,
        label = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
        },
        trailingIcon = {
            if (isSearchActive) {
                IconButton(
                    onClick = {
                        query = ""
                        isSearchActive = false
                        keyboardController?.hide()
                    }
                ) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "Clear Icon")
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                // Handle search action here
                keyboardController?.hide()
            }
        ),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            textColor = Color.Gray
        ),
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
    )
}