package com.example.fdev.View

import CartScreen
import CartViewModel
import LayoutProductScreen
import RetrofitService
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fdev.ViewModel.NetWork.ApiService
import com.example.fdev.navigator.GetLayoutButtonBarNavigator

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
        HOME,
        LOGIN,
        REGISTER,
        PRODUCT,
        HELP,
        CONTACT,
        MAIL,
        MYREVIEW,
        CART,
        CHECKOUT,
        FAVORITES,
        SEARCH,
        NOTIFICATIONS,
        CONGRATSSCREEN,
        PAYMENTMETHODSCREEN,
        ADDPAYMENTMETHOD,
        REVIEW,
        LANGUAGE,
        ACCOUNTS,
        WRITEREVIEW
    }

    @Composable
    fun GetlayoutNavigation() {
        val navController = rememberNavController()
        val retrofitService = RetrofitService() // Khởi tạo RetrofitService
        val apiService: ApiService = retrofitService.fdevApiService // Lấy ApiService
        // Giả sử bạn có email và mật khẩu của người dùng khi đăng nhập

        // Kiểm tra trạng thái người dùng khi MainScreen được khởi tạo

        NavHost(navController = navController, startDestination = Router.WELCOME.name) {
            composable(Router.WELCOME.name) {
                LayoutWelcome(navController = navController)
            }
            composable(Router.SETTING.name) {
                LayoutSetting(navController = navController)
            }
            composable(Router.HOME.name) {
                GetLayoutButtonBarNavigator(navController)
            }
            composable(Router.LOGIN.name) {
                LayoutLoginScreen(navController = navController)
            }
            composable(Router.REGISTER.name) {
                LayoutRegisterScreen(navController = navController)
            }
            composable(Router.PRODUCT.name) {
                // Truyền cartViewModel vào LayoutProductScreen
                LayoutProductScreen(navController = navController)
            }
            composable(Router.HELP.name){
                LayoutHelp(navController = navController)
            }
            composable(Router.CONTACT.name) {
                LayoutContact(navController = navController)
            }
            composable(Router.MAIL.name) {
                LayoutMail(navController = navController)
            }
            composable(Router.MYREVIEW.name){
                MyReviewScreen(navController = navController)
            }
            composable(Router.CART.name) {
                CartScreen(navController = navController)
            }
            composable(
                route = "${Router.CHECKOUT.name}/{totalPrice}",
                arguments = listOf(navArgument("totalPrice") { type = NavType.StringType })
            ) { backStackEntry ->
                val totalPrice = backStackEntry.arguments?.getString("totalPrice") ?: "0.0"
                CheckoutScreen(navController = navController, totalPrice = totalPrice)
            }

            composable(Router.FAVORITES.name) {
                FavoritesScreen(navController = navController)
            }

            composable(Router.SEARCH.name) {
                SearchScreen(navController = navController, retrofitService = retrofitService)
            }
            composable(Router.NOTIFICATIONS.name) {
                NotificationScreen(navController = navController)
            }
            composable(Router.CONGRATSSCREEN.name) {
                CongratsScreen(navController = navController)
            }
            composable(Router.PAYMENTMETHODSCREEN.name) {
                PaymentMethodScreen(navController = navController)
            }
            composable(Router.ADDPAYMENTMETHOD.name) {
                AddPaymentMethod(navController = navController)
            }
            composable(Router.REVIEW.name) {
                ReviewScreen(navController = navController)
            }
            composable(Router.ACCOUNTS.name) {
                LayoutAccounts(navController = navController)
            }
            composable(Router.WRITEREVIEW.name) {
                WriteReviewScreen(navController = navController)
            }
        }
    }
}

