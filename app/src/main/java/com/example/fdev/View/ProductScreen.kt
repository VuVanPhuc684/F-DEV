package com.example.fdev.View

import RetrofitService
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.fdev.R
import com.example.fdev.model.Product
import com.example.fdev.ViewModel.CartViewModel
import com.example.fdev.ViewModel.NetWork.ApiService

@Composable
fun LayoutProductScreen(navController: NavHostController, cartViewModel: CartViewModel) {
    val scrollState = rememberScrollState()
    val product = navController.previousBackStackEntry?.savedStateHandle?.get<Product>("product")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(455.dp)
                .padding(top = 30.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            product?.let {
                Image(
                    painter = rememberImagePainter(data = it.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 65.dp)
                        .fillMaxSize()
                        .width(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 50.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(end = 260.dp, top = 20.dp)
                    .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }
        }

        product?.let {
            Text(
                text = it.name,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily.Serif,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 15.dp, top = 20.dp)
            )
            Text(
                text = "${it.price.toDouble()}",
                fontFamily = FontFamily.Serif,
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                modifier = Modifier.padding(start = 15.dp, top = 10.dp)
            )
            Text(
                text = "${it.description}",
                modifier = Modifier.padding(start = 15.dp, top = 20.dp),
                fontSize = 17.sp,
                color = Color(0xff606060),
                lineHeight = 22.sp,
                fontFamily = FontFamily.Serif
            )

            Button(
                onClick = {
                    val userName = "USER_NAME"
                    cartViewModel.addToCart(it, userName)
                    navController.navigate("CART")
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffd86d42), // Màu nền của nút
                    contentColor = Color.White // Màu văn bản
                ),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(text = "Add to Cart", fontFamily = FontFamily.Serif)
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {

    val retrofitService = RetrofitService()
    val cartViewModel = CartViewModel(retrofitService.fdevApiService)
    LayoutProductScreen(navController = rememberNavController(), cartViewModel = cartViewModel)
}

