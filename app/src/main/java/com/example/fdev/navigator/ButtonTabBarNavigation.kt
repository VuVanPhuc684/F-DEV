package com.example.fdev.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R
import com.example.fdev.View.FavoritesScreen
import com.example.fdev.View.LayoutHomeScreen
import com.example.fdev.View.LayoutPersonScreen
import com.example.fdev.View.LayoutSearchScreen
import com.example.fdev.View.LayoutShoppingScreen
import com.example.fdev.View.NotificationScreen
import com.example.fdev.View.ProfileScreen
import com.example.fdev.View.SearchScreen

enum class ROUTER {
    home,
    favourite,
    Notification,
    search,
    person
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetLayoutButtonBarNavigator(navHostController: NavHostController) {
    var isSelected by rememberSaveable {
        mutableStateOf(ROUTER.home.name)
    }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
            ) {
                // Home
                NavigationBarItem(
                    selected = isSelected === ROUTER.home.name,
                    onClick = {
                        isSelected = ROUTER.home.name
                        navController.navigate(ROUTER.home.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.home_anh),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF059BEE),
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFFFFFFF),


                        ),
                )

                // Favourite
                NavigationBarItem(
                    selected = isSelected === ROUTER.favourite.name,
                    onClick = {
                        isSelected = ROUTER.favourite.name
                        navController.navigate(ROUTER.favourite.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.favourite),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp, 20.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF059BEE),
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFFFFFFF)

                    ),
                )

                // Shopping
                NavigationBarItem(
                    selected = isSelected === ROUTER.Notification.name,
                    onClick = {
                        isSelected = ROUTER.Notification.name
                        navController.navigate(ROUTER.Notification.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF059BEE),
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFFFFFFF),

                        ),
                )

                // Search
                NavigationBarItem(
                    selected = isSelected === ROUTER.search.name,
                    onClick = {
                        isSelected = ROUTER.search.name
                        navController.navigate(ROUTER.search.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.search_anh),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF059BEE),
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFFFFFFF),

                        ),
                )

                // Person
                NavigationBarItem(
                    selected = isSelected === ROUTER.person.name,
                    onClick = {
                        isSelected = ROUTER.person.name
                        navController.navigate(ROUTER.person.name) {
                            popUpTo(0)
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = null,
                            modifier = Modifier.size(25.dp, 25.dp)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFF059BEE),
                        unselectedIconColor = Color.Black,
                        indicatorColor = Color(0xFFFFFFFF),

                        ),
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White
                )
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(1.dp))
            NavHost(
                navController = navController,
                startDestination = isSelected
            ) {
                composable(ROUTER.home.name) {
                    LayoutHomeScreen(navHostController)
                }
                composable(ROUTER.favourite.name) {
                    FavoritesScreen(navHostController) }
                composable(ROUTER.Notification.name) {
                    NotificationScreen(navController)
                }
                composable(ROUTER.search.name) {
                    SearchScreen(navHostController)
                }
                composable(ROUTER.person.name) {
                    ProfileScreen(navHostController)
                }
            }
        }
    }
}
