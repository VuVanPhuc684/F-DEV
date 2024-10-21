package com.example.fdev.View

import RetrofitService
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.fdev.R
import com.example.fdev.ViewModel.ProductViewModel
import com.example.fdev.model.Product

@Composable
fun LayoutHomeAdminScreen(navController: NavHostController, retrofitService: RetrofitService) {

    val scrollSate = rememberScrollState()
    var statusType by remember { mutableStateOf("Popular") }
    val listTypeProduct = mutableListOf(
        TypeProduct("Popular", R.drawable.star_1),
        TypeProduct("Design", R.drawable.chair_1),
        TypeProduct("UI/UX", R.drawable.table_1),
        TypeProduct("3D ART", R.drawable.image_1),
        TypeProduct("Photo", R.drawable.camera_1),
        TypeProduct("Author", R.drawable.writer),
    )

    // Sử dụng ProductViewModel và lấy sản phẩm từ API
    val productViewModel: ProductViewModel = remember { ProductViewModel(retrofitService) }
    val products by productViewModel.productList

    // Gọi API khi màn hình vừa được hiển thị
    LaunchedEffect(Unit) {
        productViewModel.fetchProductList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        // Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.search_anh),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff808080)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Make home",
                    fontFamily = FontFamily.Serif,
                    fontSize = 15.sp,
                    color = Color(0xff909090)
                )
                Text(
                    text = "BEAUTIFUL",
                    fontFamily = FontFamily.Serif,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.shopping),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp, 20.dp),
                    tint = Color(0xff808080)
                )
            }
        }

        // Type
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .horizontalScroll(scrollSate),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listTypeProduct.forEachIndexed { _, type ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 5.dp, end = 10.dp)
                ) {
                    IconButton(
                        onClick = { statusType = type.type },
                        modifier = Modifier
                            .shadow(
                                elevation = 1.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                            .background(
                                Color(
                                    if (statusType === type.type) 0xff303030 else 0xffF5F5F5
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp)
                    ) {
                        Icon(
                            painterResource(id = type.icon),
                            contentDescription = null,
                            modifier = Modifier.size(26.dp, 26.dp),
                            tint = Color(
                                if (statusType === type.type) 0xffFFFFFF else 0xff909090
                            )
                        )
                    }
                    Text(
                        text = type.type,
                        modifier = Modifier.padding(top = 10.dp),
                        fontFamily = FontFamily.Serif
                    )
                }
            }
        }

        // ListProduct: Thay đổi để hiển thị sản phẩm từ API
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(products) { item ->
                    ItemProductAdmin(model = item, navController = navController)
                }
            }
        }
    }
}

@Composable
fun ItemProductAdmin(navController: NavHostController, model: Product) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 25.dp, bottom = 15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                modifier = Modifier
                    .width(200.dp) // Thay đổi chiều rộng
                    .height(250.dp) // Thay đổi chiều cao
                    .clip(shape = RoundedCornerShape(8.dp))
                    .clickable {
                        navController.currentBackStackEntry?.savedStateHandle?.set("product", model)
                        navController.navigate("PRODUCT")
                    },
                painter = rememberImagePainter(
                    data = model.image,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.a_1) // Hình ảnh placeholder
                        error(R.drawable.error) // Hình ảnh khi lỗi
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop // Thay đổi sang Crop nếu bạn muốn cắt ảnh
            )
        }

        Text(
            text = model.name,
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xff606060)
        )
        Text(
            text = model.price.toString(),
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color(0xff303030),
            fontWeight = FontWeight(700)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeAdminScreen() {
    LayoutHomeAdminScreen(navController = rememberNavController(), retrofitService = RetrofitService())
}