package com.example.fdev.View




import CartViewModel
import FavouriteViewModel
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.fdev.model.Product




data class FavouriteItem(
    val product: Product,
    val name: String,
    val price: Number,
    val image: String
)




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(navController: NavHostController,favouriteViewModel:FavouriteViewModel= viewModel()) {
    // Dữ liệu mẫu
    val favouriteItems by favouriteViewModel.favouriteItems.collectAsState()  // Lấy danh sách sản phẩm trong giỏ hàng
    val selectedIndex = remember { mutableStateOf(1) } // Khởi tạo trạng thái cho NavigationBar
    LaunchedEffect(Unit) {
        // Lấy giỏ hàng của người dùng khi màn hình được hiển thị
        favouriteViewModel.getFavouriteItems()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = {
                            navController.navigate("SEARCH")
                            /* Do something */ }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                        Text(
                            text = "Favorites",
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(onClick = {
                            /* Do something */ }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        floatingActionButton = {


        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            items(favouriteItems) { item ->
                FavoriteItemRow(item, onRemoveItem = {
                    favouriteViewModel.removeFromFavourites(item.name)  // Sử dụng tên sản phẩm để xóa
                })
            }
        }
    }
}


@Composable
fun FavoriteItemRow(item: FavouriteItem, onRemoveItem: (FavouriteItem) -> Boolean) {
    val cartViewModel : CartViewModel = viewModel()
    val navController: NavHostController = rememberNavController()
    val product = navController.previousBackStackEntry?.savedStateHandle?.get<Product>("product")
    var showDialog by remember { mutableStateOf(false) }  // Trạng thái để hiển thị Dialog
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(data = item.image),
            contentDescription = item.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )


        Spacer(modifier = Modifier.width(16.dp))


        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
            )
            Text(
                text = "$ ${item.price}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            )
        }


        IconButton(
            onClick = { showDialog = true/* Xóa mục này */ },
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Icon(Icons.Default.Close, contentDescription = "Remove")
        }


        // Hiển thị thông báo xác nhận khi showDialog = true
        if (showDialog) {
            AlertDialog(
                onDismissRequest = {
                    showDialog = false  // Ẩn Dialog khi người dùng click ra ngoài
                },
                title = {
                    Text(text = "Xác nhận xóa")
                },
                text = {
                    Text("Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            onRemoveItem(item)
                            showDialog = false  // Ẩn Dialog sau khi xóa


                        }
                    ) {
                        Text("Đồng ý")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDialog = false }  // Ẩn Dialog nếu người dùng hủy
                    ) {
                        Text("Hủy")
                    }
                }
            )
        }


        Spacer(modifier = Modifier.width(8.dp))


        IconButton(
            onClick = {
                product?.let {
                    cartViewModel.addToCart(item.product, 1)
                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_LONG).show()
                }
                /* Thêm vào giỏ hàng */ },
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = "Add to cart")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen(navController = rememberNavController())
}

