package com.example.fdev.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MyReviewScreen() {
    LayOutMyReview(navController = rememberNavController())
}

@Composable
fun LayOutMyReview(navController: NavHostController) {
    val painterBack: Painter = painterResource(id = R.drawable.back)
    val painterProduct: Painter = painterResource(id = R.drawable.sanpham)
    val painterAvatar: Painter = painterResource(id = R.drawable.admin)
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, top = 50.dp, end = 16.dp, bottom = 16.dp)
            .verticalScroll(scrollState)
    ) {
        // Top bar with back icon and profile avatar
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(20.dp)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "My reviews",
                modifier = Modifier.weight(1f),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontSize = 20.sp
                ),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterAvatar,
                contentDescription = "Profile Avatar",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
            )
        }

        // #0Review card
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
                .clip(RoundedCornerShape(12.dp))
                .padding(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.Top) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterProduct,
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Camp Mograph",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$0",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Star rating
                Row {
                    repeat(5) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Review description
                Text(
                    text = "Bức tranh có màu sắc sống động, chi tiết rõ nét, và khung chắc chắn. Khi treo lên tường, tranh tạo cảm giác sang trọng. Chất lượng vượt trội so với giá cả. Mình rất hài lòng và sẽ giới thiệu cho bạn bè.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF909191),
                    ),
                )
            }
        }
//#1
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 1.dp, shape = RoundedCornerShape(5.dp))
                .clip(RoundedCornerShape(12.dp))
                .padding(20.dp)
        ) {
            Column(verticalArrangement = Arrangement.Top) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterProduct,
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = "Common Good Magazine",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$50",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black,
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Star rating
                Row {
                    repeat(5) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Star",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Review description
                Text(
                    text = "Mình đã mua bức tranh này và rất hài lòng với chất lượng. Màu sắc rất sống động và chi tiết trong tranh rất rõ nét. Khi treo lên tường, bức tranh mang lại cảm giác sang trọng và làm không gian nhà thêm ấm cúng .",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFF909191),
                    ),
                )
            }
        }
    }
}
