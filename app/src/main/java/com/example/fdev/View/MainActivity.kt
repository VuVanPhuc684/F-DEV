package com.example.fdev.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GetlayoutNavigation()
        }
    }

    enum class Router {
        WELCOME,
        SETTING,
    }

    @Composable
    fun GetlayoutNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Router.WELCOME.name) {
            composable(Router.WELCOME.name) {
                LayoutWelcome(navController = navController)
            }
            composable(Router.SETTING.name){
                LayoutSetting(navController = navController)
            }
        }


    }
}
