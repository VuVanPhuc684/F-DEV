package com.example.fdev.View

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreen() {
    LayoutSearchScreen(navController = rememberNavController())
}

@Composable
fun LayoutSearchScreen(navController: NavHostController) {

}
