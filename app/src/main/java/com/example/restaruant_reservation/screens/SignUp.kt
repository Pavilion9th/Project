package com.example.restaruant_reservation.screens

import android.widget.Toast
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.restaruant_reservation.R
import com.example.restaruant_reservation.ui.theme.BgColor
import com.example.restaruant_reservation.ui.theme.Brown
import com.example.restaruant_reservation.ui.theme.RedText
import com.example.restaruant_reservation.ui.theme.Red2
import com.example.restaruant_reservation.ui.theme.White
import com.example.restaruant_reservation.ui.theme.humanColor
import com.example.restaruant_reservation.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUp(navController: NavController) {
    val context = LocalContext.current

    val fullName = remember {
        mutableStateOf("")
    }
    val phoneNumber = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val confirmPassword = remember {
        mutableStateOf("")
    }

    val fontFamily = FontFamily(Font(R.font.montserratbold))
    val bold = FontFamily(Font(R.font.montserratbolditalic))
    val checked = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgColor)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 65.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.padding(bottom = 35.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.los),
                    contentDescription = "Los Pollos Hermanos",
                    modifier = Modifier
                        .size(65.dp)
                        .padding(vertical = 0.dp)
                )
                Text(
                    text = "Los Pollos \nHermanos", fontSize = 23.sp,
                    modifier = Modifier.padding(vertical = 0.dp),
                    fontFamily = bold,
                    color = Brown
                )

            }
            TextField(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 15.dp)
                    .width(335.dp),
                value = fullName.value,
                onValueChange = { fullName.value = it },
                maxLines = 1,
                placeholder = { Text(text = "Full name") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = humanColor,
                    cursorColor = Brown,
                    containerColor = White,

                    ),
                shape = RoundedCornerShape(12.dp),
//                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            var msg by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.width(335.dp),
                value = phoneNumber.value,
                onValueChange = {
                    phoneNumber.value = it
                    msg = if (it[0] == '+') {
                        ""
                    } else {
                        "incorrect number"
                    }
                },
                maxLines = 1,
                placeholder = { Text(text = "Phone number") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = humanColor,
                    cursorColor = Brown,
                    containerColor = White,

                    ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Text(msg)
            TextField(
                modifier = Modifier
                    .width(335.dp)
                    .padding(bottom = 15.dp),
                value = email.value,
                onValueChange = { email.value = it },
                maxLines = 1,
                placeholder = { Text(text = "Email") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = humanColor,
                    cursorColor = Brown,
                    containerColor = White,

                    ),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            TextField(
                modifier = Modifier.width(335.dp),
                value = password.value,
                onValueChange = { password.value = it },
                maxLines = 1,
                placeholder = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = humanColor,
                    cursorColor = Brown,
                    containerColor = White,

                    ),
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            TextField(
                modifier = Modifier
                    .width(335.dp)
                    .padding(top = 15.dp, bottom = 15.dp),
                value = confirmPassword.value,
                onValueChange = { confirmPassword.value = it },
                maxLines = 1,
                placeholder = { Text(text = "Confirm password") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = humanColor,
                    cursorColor = Brown,
                    containerColor = White,

                    ),
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
//                Row(modifier = Modifier.height(50.dp), verticalAlignment = Alignment.CenterVertically) {
//                    Checkbox(
//                        checked = checked.value,
//                        onCheckedChange = { isChecked -> checked.value = isChecked }
//                    )
//                    Text(
//                        if (checked.value) "don't remember" else "remember me", fontSize = 14.sp,
//                        modifier = Modifier.padding(end = 15.dp),
//                        fontFamily = fontFamily,
//                        color = Black
//                    )
//                    Text(
//                        text = "forgot password?", fontSize = 14.sp,
//                        modifier = Modifier
//                            .padding(vertical = 0.dp)
//                            .clickable { navController.navigate(Screens.ForgotPassword1.route) },
//                        fontFamily = fontFamily,
//                        color = Red1,
//
//                        )
//
//                }
            Button(
                onClick = {
                    if (fullName.value.isEmpty() || phoneNumber.value.length < 12 || email.value.length < 11 || email.value.takeLast(
                            10
                        ) != "@gmail.com" || password.value.length < 7 || password.value!=confirmPassword.value
                    ) {
                        Toast.makeText(context,"Fill all of them correctly",Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    else{
                        Toast.makeText(context,"Successfully signed up", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screens.HomePage.route){
                            popUpTo(navController.graph.id){
                                inclusive=true
                            }
                        }
                    }
                }, modifier = Modifier
                    .width(327.dp)
                    .height(44.dp), colors = ButtonDefaults.buttonColors(containerColor = Red2),
                shape = RoundedCornerShape(7.dp)
            ) {
                Text(
                    text = "Signup", fontSize = 18.sp,
                    modifier = Modifier
                        .padding(vertical = 0.dp)
                        .clickable { navController.navigate(Screens.HomePage.route) },
                    fontFamily = fontFamily
                )
            }
            Text(
                text = "Already have account?Log in", fontSize = 14.sp,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .clickable { navController.navigate(Screens.Login.route) },
                fontFamily = fontFamily,
                color = RedText,
            )
        }
    }

}