package com.example.fdev.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R
import com.example.fdev.ViewModel.ReviewViewModel
import com.example.fdev.model.ReviewRespone

@Composable
fun ReviewScreen(
    navController: NavController,
    reviewViewModel: ReviewViewModel = androidx.lifecycle.viewmodel.compose.viewModel() // ViewModel
) {
    // Lấy danh sách review từ ViewModel
    val reviewList by reviewViewModel.reviewList.collectAsState()
    val errorMessage by reviewViewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .padding(20.dp, top = 50.dp, bottom = 10.dp, end = 20.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.left_black),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .clickable {navController.navigate("PRODUCT") },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Đánh giá & Nhận xét",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium
            )
        }

        ProductInfo()

        Spacer(modifier = Modifier.height(20.dp))

        // Hiển thị danh sách review hoặc thông báo lỗi
        if (errorMessage == null) {
            if (reviewList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(reviewList.size) { index ->
                        ReviewItem(itemReview = reviewList[index])
                    }
                }
            } else {
                Text(
                    text = "Không có đánh giá nào",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }
        } else {
            Text(
                text = errorMessage ?: "",
                fontSize = 18.sp,
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Nút viết review ở dưới cùng
        Button(
            onClick = {
                navController.navigate("WRITEREVIEW")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Viết đánh giá",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }

    // Gọi API lấy review khi màn hình được mở
    androidx.compose.runtime.LaunchedEffect(Unit) {
        reviewViewModel.fetchReviews()
    }
}

@Composable
fun ProductInfo() {
    // Phần thông tin sản phẩm: ảnh sản phẩm, điểm đánh giá, số lượng review
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_test),  // Ảnh sản phẩm
            contentDescription = null,
            modifier = Modifier
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Minimal Stand", // Tên sản phẩm
                fontSize = 20.sp,
                color = Color.Gray
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star1),
                    contentDescription = null,
                    tint = Color.Yellow,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "4.5",  // Điểm đánh giá trung bình
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "10 reviews",  // Số lượng review
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ReviewItem(itemReview: ReviewRespone) {
    Card(
        modifier = Modifier
            .padding(top = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_test),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = itemReview.userId,  // Tên người dùng
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = itemReview.time ?: "",  // Thời gian đánh giá
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                repeat(itemReview.rate) {
                    Icon(
                        painter = painterResource(id = R.drawable.star1),
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = itemReview.comment,  // Nội dung bình luận
                fontSize = 14.sp,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewReview() {
    val navController = rememberNavController()
    ReviewScreen(navController)
}