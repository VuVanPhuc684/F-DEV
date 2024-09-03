package com.example.fdev.View

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun WelcomeScreen() {
    LayoutWelcome(navController= rememberNavController() )
}


@Composable
fun LayoutWelcome(navController: NavHostController) {
    Row (
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(text = "màn hình chào",
            modifier = Modifier.padding(start = 50.dp),
            style = TextStyle(
                color = Color.Red,
                fontSize = 50.sp
            )
        )
        LaunchedEffect(Unit) {
            delay(5000)
            navController.navigate("Setting")
        }
    }
}