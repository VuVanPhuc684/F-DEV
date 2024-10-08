package com.example.fdev.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R
import com.example.fdev.ViewModel.ReviewViewModel
import com.example.fdev.model.ReviewRespone

@Composable
fun MyReviewScreen(
    navController: NavHostController,
    reviewViewModel: ReviewViewModel = viewModel() // ViewModel
) {
    // Lấy danh sách review từ ViewModel
    val reviewList by reviewViewModel.reviewList.collectAsState()
    val errorMessage by reviewViewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "My reviews",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Image(
                painterResource(id = R.drawable.admin),
                contentDescription = "Profile Avatar",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Hiển thị danh sách review hoặc thông báo lỗi
        if (errorMessage == null) {
            if (reviewList.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(reviewList.size) { index ->
                        MyReviewItem(itemReview = reviewList[index])
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
    }

    // Gọi API lấy review khi màn hình được mở
    LaunchedEffect(Unit) {
        reviewViewModel.fetchReviews()
    }
}

@Composable
fun MyReviewItem(itemReview: ReviewRespone) {
    Spacer(modifier = Modifier.height(20.dp))
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(12.dp))
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sanpham),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "Tên sản phẩm: " + itemReview.userId,  // Tên người dùng
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Thời gian: " + itemReview.time ?: "",  // Thời gian đánh giá
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = "Tổng số sao: " + itemReview.rate.toString(),  // Nội dung bình luận
                        fontSize = 14.sp,
                        textAlign = TextAlign.Justify
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

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
fun PreviewMyReviewScreen() {
    MyReviewScreen(navController = rememberNavController())
}



