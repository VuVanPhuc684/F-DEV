package com.example.fdev.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R
import kotlinx.coroutines.delay

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Mail() {
    LayoutMail(navController= rememberNavController() )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutMail(navController: NavHostController) {

    val painter0: Painter = painterResource(id = R.drawable.back)
    val painter1: Painter = painterResource(id = R.drawable.user)

    var Name by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var NoiDung by remember { mutableStateOf("") }


    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 16.dp)
            .verticalScroll(scrollState)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painter0,
                contentDescription = "Back",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
            Text(
                text = "Form liên hệ ",
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painter1,
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            OutlinedTextField(
                value = Name,
                onValueChange = { Name = it },
                label = { Text("Tên") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(size = 8.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFF909191),
                        shape = RoundedCornerShape(size = 8.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray,
                ),
                shape = RoundedCornerShape(size = 8.dp),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Serif
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            OutlinedTextField(
                value = Email,
                onValueChange = { Email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(size = 8.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFF909191),
                        shape = RoundedCornerShape(size = 8.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray,
                ),
                shape = RoundedCornerShape(size = 8.dp),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Serif
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        ) {
            OutlinedTextField(
                value = NoiDung,
                onValueChange = { NoiDung = it },
                label = { Text("Nội dung yêu cầu ") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White, RoundedCornerShape(size = 8.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFF909191),
                        shape = RoundedCornerShape(size = 8.dp)
                    ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Gray,
                ),
                shape = RoundedCornerShape(size = 8.dp),
                textStyle = TextStyle(
                    fontFamily = FontFamily.Serif
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(25.dp))
                .shadow(elevation = 8.dp, shape = RoundedCornerShape(25.dp))
                .background(color = Color(0xFFe7e7e7))
                .clickable {
                    Toast.makeText(context,"sent successfully", Toast.LENGTH_SHORT).show()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Gửi",
                color = Color.Black,
                fontSize = 18.sp
            )
        }

    }
}

