package com.example.fdev.View

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R

@Composable
fun LayoutRegisterScreen(navController: NavHostController) {
    val context = LocalContext.current
    var isShowPass by remember {
        mutableStateOf(false)
    }
    var isShowConfirmPass by remember {
        mutableStateOf(false)
    }
    var email by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var pass by remember {
        mutableStateOf("")
    }
    var confirmpass by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 80.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(color = Color(0xffBDBDBD))
                ) {}
                Image(
                    painter = painterResource(id = R.drawable.design), contentDescription
                    = "logo",
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .size(50.dp, 50.dp)
                        .weight(1f)
                )
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(color = Color(0xffBDBDBD))
                ) {}
            }
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                Column(
                    modifier = Modifier.padding(
                        top = 20.dp, start = 10.dp, bottom = 15.dp
                    )
                ) {

                    Text(
                        text = "WELCOME",
                        fontFamily = FontFamily.Serif,
                        color = Color(0xff303030),
                        fontWeight = FontWeight(700),
                        fontSize = 35.sp
                    )

                }

                Column(
                    modifier = Modifier
                        .size(370.dp, 580.dp)
                        .shadow(
                            elevation = 3.dp,
                            shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                        )
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                start = 20.dp, end = 20.dp, top = 30.dp, bottom = 30.dp
                            )
                    ) {
                        Column {
                            Text(
                                text = "Name",
                                color = Color(0xff909090),
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier.padding(bottom = 3.dp)
                            )
                            TextField(
                                value = name,
                                onValueChange = {
                                    name = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color(0xffE0E0E0),
                                    focusedIndicatorColor = Color(0xffE0E0E0),
                                    cursorColor = Color.Black
                                ),
                                textStyle = TextStyle(
                                    fontFamily = FontFamily.Serif
                                ),

                                )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Column {
                            Text(
                                text = "Email",
                                color = Color(0xff909090),
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier.padding(bottom = 3.dp)
                            )
                            TextField(
                                value = email,
                                onValueChange = {
                                    email = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color(0xffE0E0E0),
                                    focusedIndicatorColor = Color(0xffE0E0E0),
                                    cursorColor = Color.Black
                                ),
                                textStyle = TextStyle(
                                    fontFamily = FontFamily.Serif
                                ),

                                )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Column {
                            Text(
                                text = "Password",
                                color = Color(0xff909090),
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier.padding(bottom = 3.dp)
                            )
                            TextField(
                                value = pass,
                                onValueChange = {
                                    pass = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color(0xffE0E0E0),
                                    focusedIndicatorColor = Color(0xffE0E0E0),
                                    cursorColor = Color.Black
                                ),
                                trailingIcon = {
                                    IconButton(onClick = {
                                        isShowPass = !isShowPass
                                    }) {
                                        Icon(
                                            painter = painterResource(
                                                id = if (isShowPass) R.drawable.an else R.drawable.show
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier.size(20.dp, 20.dp)
                                        )
                                    }
                                },
                                visualTransformation = if (isShowPass) VisualTransformation.None else PasswordVisualTransformation(),
                                textStyle = TextStyle(
                                    fontFamily = FontFamily.Serif
                                ),
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Column {
                            Text(
                                text = "Confirm Password",
                                color = Color(0xff909090),
                                fontSize = 15.sp,
                                fontFamily = FontFamily.Serif,
                                modifier = Modifier.padding(bottom = 3.dp)
                            )
                            TextField(
                                value = confirmpass,
                                onValueChange = {
                                    confirmpass = it
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.Transparent,
                                    unfocusedContainerColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color(0xffE0E0E0),
                                    focusedIndicatorColor = Color(0xffE0E0E0),
                                    cursorColor = Color.Black
                                ),
                                trailingIcon = {
                                    IconButton(onClick = {
                                        isShowConfirmPass = !isShowConfirmPass
                                    }) {
                                        Icon(
                                            painter = painterResource(
                                                id = if (isShowConfirmPass) R.drawable.an
                                                else R.drawable.show
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier.size(20.dp, 20.dp)
                                        )
                                    }
                                },
                                visualTransformation = if (isShowConfirmPass) VisualTransformation.None else PasswordVisualTransformation(),
                                textStyle = TextStyle(
                                    fontFamily = FontFamily.Serif
                                ),
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 15.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Button(
                                onClick = { /*TODO*/
                                    navController.navigate("HOME")
                                },

                                modifier = Modifier.size(290.dp, 50.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xff242424)
                                ),
                                shape = RoundedCornerShape(8.dp)

                            ) {
                                Text(
                                    text = "Sign up",
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight(600)
                                )
                            }
                            Row {
                                Text(
                                    text = "Already have account?",
                                    modifier = Modifier.padding(top = 20.dp),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color(0xff909090)
                                )
                                Text(
                                    text = "LOGIN",
                                    modifier = Modifier
                                        .padding(top = 20.dp, start = 5.dp)
                                        .selectable(
                                            selected = true,
                                            onClick = {
                                                navController.navigate("login")

                                            }
                                        ),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color(0xff303030),
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }

                        }


                    }

                }
            }

        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreen() {
    LayoutRegisterScreen(navController = rememberNavController())
}