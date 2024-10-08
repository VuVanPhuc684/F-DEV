//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Close
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import coil.compose.rememberImagePainter
//import com.example.fdev.ViewModel.CartViewModel
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CartScreen(navController: NavHostController, cartViewModel: CartViewModel = viewModel()) {
//    val cartItems by cartViewModel.cartItems.collectAsState()
//    val totalPrice = cartViewModel.getTotalPrice()
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text("My Cart", style = MaterialTheme.typography.headlineSmall)
//                }
//            )
//        },
//        bottomBar = {
//            Column(
//                modifier = Modifier.fillMaxWidth().padding(16.dp)
//            ) {
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    Text("Total:", fontWeight = FontWeight.Bold)
//                    Text("$ $totalPrice", fontWeight = FontWeight.Bold)
//                }
//
//                Button(
//                    onClick = { navController.navigate("CHECKOUT") },
//                    modifier = Modifier.fillMaxWidth().height(56.dp),
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
//                ) {
//                    Text("Check out", color = Color.White)
//                }
//            }
//        }
//    ) { innerPadding ->
//        LazyColumn(contentPadding = innerPadding, modifier = Modifier.padding(horizontal = 16.dp)) {
//            items(cartItems) { item ->
//                CartItemRow(item, onRemoveItem = {
//                    cartViewModel.removeFromCart(item.product)
//                })
//            }
//        }
//    }
//}
//
//
//
//
//@Composable
//fun CartItemRow(item: CartItem, onRemoveItem: () -> Unit) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // Hiển thị ảnh sản phẩm
//        Image(
//            painter = rememberImagePainter(data = item.image),
//            contentDescription = item.name,
//            modifier = Modifier
//                .size(80.dp)
//                .clip(RoundedCornerShape(12.dp)),
//            contentScale = ContentScale.Crop
//        )
//
//        Spacer(modifier = Modifier.width(16.dp))
//
//        // Hiển thị tên và giá sản phẩm
//        Column(
//            modifier = Modifier.weight(1f)
//        ) {
//            Text(
//                text = item.name,
//                style = MaterialTheme.typography.bodyMedium.copy(
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            )
//            Text(
//                text = "$ ${item.price}",
//                style = MaterialTheme.typography.bodySmall.copy(
//                    fontSize = 14.sp,
//                    color = Color.Gray
//                )
//            )
//        }
//
//        // Nút xóa sản phẩm khỏi giỏ hàng
//        IconButton(
//            onClick = onRemoveItem,
//            modifier = Modifier.size(40.dp)
//        ) {
//            Icon(Icons.Default.Close, contentDescription = "Remove")
//        }
//    }
//}
//
//data class CartItem(
//    val product: String,
//    val name: String,
//    val price: Double,
//    val image: String
//)
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun CartScreenPreview() {
//    CartScreen(navController = rememberNavController())
//}
//
package com.example.fdev.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.ViewModel.CartItemRow
import com.example.fdev.ViewModel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController, cartViewModel: CartViewModel = viewModel()) {
    val cartItems by cartViewModel.cartItems.collectAsState()
    val totalPrice = cartViewModel.getTotalPrice()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("My Cart", style = MaterialTheme.typography.headlineSmall)
                }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Total:", fontWeight = FontWeight.Bold)
                    Text("$ $totalPrice", fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = { navController.navigate("CHECKOUT") },
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text("Check out", color = Color.White)
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding, modifier = Modifier.padding(horizontal = 16.dp)) {
            items(cartItems) { item ->
                CartItemRow(item, onRemoveItem = {
                    cartViewModel.removeFromCart(item.product)
                })
            }
        }
    }
}



data class CartItem(
    val product: String,
    val name: String,
    val price: Double,
    val image: String
)

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    CartScreen(navController = rememberNavController())
}
