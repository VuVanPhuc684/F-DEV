import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.fdev.R
import com.example.fdev.model.Product

@Composable
fun LayoutProductScreen(navController: NavHostController, cartViewModel: CartViewModel) {
    val scrollState = rememberScrollState()
    val product = navController.previousBackStackEntry?.savedStateHandle?.get<Product>("product")
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp) // Thêm padding cho toàn bộ Column
    ) {
        // Box layout for image and radio buttons
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(455.dp)
                .padding(top = 30.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            // Image display
            product?.let {
                Image(
                    painter = rememberImagePainter(data = it.image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 65.dp)
                        .fillMaxSize()
                        .width(200.dp)
                        .clip(
                            shape = RoundedCornerShape(bottomStart = 50.dp)
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        // Phần hiển thị hình ảnh sản phẩm và nút quay lại
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
                        .padding(start = 16.dp) // Thay đổi padding để cải thiện khoảng cách
                        .fillMaxWidth() // Đảm bảo hình ảnh chiếm toàn bộ chiều rộng
                        .height(300.dp) // Giảm chiều cao để phù hợp hơn với bố cục
                        .clip(RoundedCornerShape(bottomStart = 50.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            // Nút quay lại
            // Back button
            IconButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .padding(end = 260.dp, top = 20.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp, 15.dp)
                )
            }

        }

        // Phần hiển thị thông tin sản phẩm
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            product?.let {
                // Tên sản phẩm
                Text(
                    text = it.name,
                    fontWeight = FontWeight(500),
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 4.dp) // Khoảng cách dưới
                )
            // Radio buttons
            Column(
                modifier = Modifier
                    .padding(end = 260.dp, top = 120.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(10.dp)
            ) {
                CustomRadioButton(
                    selected = true,
                    onClick = { /*TODO*/ },
                    outerColor = Color.Gray,
                    innerColor = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomRadioButton(
                    selected = false,
                    onClick = { /*TODO*/ },
                    outerColor = Color(0xffF0F0F0),
                    innerColor = Color(0xffB4916C)
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomRadioButton(
                    selected = false,
                    onClick = { /*TODO*/ },
                    outerColor = Color(0xffE4CBAD),
                    innerColor = Color(0xffE4CBAD)
                )
            }
        }

        // Product details
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, top = 20.dp)
        ) {
            product?.let {
                Text(
                    text = it.name,
                    fontWeight = FontWeight(500),
                    fontFamily = FontFamily.Serif,
                    fontSize = 24.sp,
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                product?.let {
                    Text(
                        text = "${it.price}",
                        fontFamily = FontFamily.Serif,
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                    )
                }
            }

                // Giá sản phẩm
                Text(
                    text = "$${it.price}",
                    fontSize = 30.sp,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(top = 10.dp, bottom = 25.dp) // Khoảng cách trên và dưới
                )

                // Đánh giá
                Row(
                    modifier = Modifier.padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sta),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "4.5",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        modifier = Modifier.padding(start = 7.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp) // Thêm padding cho toàn bộ Row
                            .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp)) // Thêm nền với bo tròn
                            .border(1.dp, Color(0xFFCCCCCC), shape = RoundedCornerShape(8.dp)) // Thêm viền
                            .padding(12.dp) // Padding cho nội dung bên trong Row
                    ) {
                        Text(
                            text = "(50 reviews)",
                            fontSize = 14.sp,
                            color = Color(0xff808080),
                            modifier = Modifier.padding(start = 10.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp)) // Thêm khoảng cách giữa các Text

                        Text(
                            text = "Xem đánh giá",
                            fontSize = 14.sp,
                            color = Color(0xFF007BFF), // Màu xanh cho chữ "Xem đánh giá"
                            modifier = Modifier
                                .clickable { navController.navigate("REVIEW/${product?.id}") // Thay đổi điều hướng đến màn hình đánh giá
                                    /* Hành động khi nhấn vào "Xem đánh giá" */ }
                                .padding(vertical = 4.dp)
                        )
                    }

                }

                // Mô tả sản phẩm
                Text(
                    text = "${it.description}",
                    modifier = Modifier.padding(top = 20.dp),
                    textAlign = TextAlign.Justify,
                    fontSize = 17.sp,
                    color = Color(0xff606060),
                    lineHeight = 22.sp
                )
            }
            // Star rating
            Row(
                modifier = Modifier.padding(top = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sta),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "4.5",
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight(700),
                    modifier = Modifier.padding(start = 7.dp)
                )
                Text(
                    text = "(50 reviews)",
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color(0xff808080),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Xem đánh giá",
                    fontSize = 17.sp,
                    modifier = Modifier
                        .padding(end = 1.dp)
                        .clickable { navController.navigate("REVIEW/${product?.id}") }
                )
                Image(
                    painterResource(id = R.drawable.right_black),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 10.dp)
                        .clickable {navController.navigate("REVIEW") },
                    contentScale = ContentScale.FillBounds,
                )

            }

            // Product description
            Text(
                text = product?.description ?: "",
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Justify,
                fontSize = 17.sp,
                color = Color(0xff606060),
                lineHeight = 22.sp,
                fontFamily = FontFamily.Serif
            )

            // Favourite and Add to Cart buttons
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(0.20f)
                        .size(60.dp)
                        .background(
                            color = Color(0xffF0F0F0),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.favourite),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            // Nút thêm vào giỏ hàng và nút yêu thích
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        product?.let {
                            favouriteViewModel.addToFavourite(it, quantity = 1)
                            Toast.makeText(context, "Favourite added to successfully", Toast.LENGTH_LONG).show()
                        } ?: run {
                            Toast.makeText(context, "Favourite not found", Toast.LENGTH_SHORT).show()
                        }/*TODO*/ },
                    modifier = Modifier
                        .size(60.dp)
                        .background(color = Color(0xffF0F0F0), shape = RoundedCornerShape(10.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.favourite),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Button(
                    onClick = {
                        product?.let {
                            cartViewModel.addToCart(it, quantity = 1)
                            Toast.makeText(context, "Product added to cart successfully", Toast.LENGTH_LONG).show()
                        } ?: run {
                            Toast.makeText(context, "Product not found", Toast.LENGTH_SHORT).show()
                        }
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .height(60.dp)
                        .shadow(elevation = 2.dp, shape = RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xff242424))
                ) {
                    Text(
                        text = "Add to cart",
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun CustomRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    outerColor: Color,
    innerColor: Color
) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(color = outerColor, shape = CircleShape)
        )
        if (selected) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(color = innerColor, shape = CircleShape)
            )
        }
    }
}
