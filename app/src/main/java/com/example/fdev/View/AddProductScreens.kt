package com.example.fdev.View

import RetrofitService
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddProductScreens() {
    LayoutAddProduct(navController = rememberNavController(), retrofitService = RetrofitService())
}

@Composable
fun LayoutAddProduct(navController: NavHostController, retrofitService: RetrofitService) {
    Column {
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(color = Color.Red)
        ){
            Text(text = "Add Product screens ",
                fontWeight = FontWeight.Bold
            )
        }
    }
}