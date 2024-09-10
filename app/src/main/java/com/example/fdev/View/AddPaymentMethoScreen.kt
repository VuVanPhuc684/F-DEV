package com.example.fdev.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.fdev.R

@Composable
fun AddPaymentMethod() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
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
                    .clickable { },
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "Thêm phương thức thanh toán",
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

        Box(
            modifier = Modifier
                .padding(10.dp, top = 20.dp, end = 10.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Black)
                .fillMaxWidth()
                .height(210.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.pain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 25.dp, bottom = 18.dp, top = 20.dp)
                    )
                    Image(
                        painterResource(id = R.drawable.visa_logo),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 25.dp, bottom = 18.dp, top = 20.dp)
                    )
                }

                Text(
                    text = "* * * *  * * * *  * * * *  XXXX",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 25.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Card Holder Name",
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 28.dp, start = 25.dp)
                    )
                    Text(
                        text = "Expiry Date",
                        color = Color.White,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 28.dp, start = 90.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "XXXXXX",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp, start = 25.dp)
                    )
                    Text(
                        text = "XX/XX",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 5.dp, start = 137.dp)
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(top = 30.dp, start = 10.dp, end = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 20.dp, 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CardHolder Name",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = "CardHolder Name",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(top = 20.dp, start = 10.dp, end = 10.dp)
        ) {
            Column(
                modifier = Modifier.padding(start = 20.dp, 10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Card Number",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Text(
                    text = "**** **** **** 3456",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 10.dp)
                .clip(RoundedCornerShape(15.dp))
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .height(60.dp),
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "CVV",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "EX: 123",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }

            Card(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .height(60.dp),
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = "Expiration Date ",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = "03/24",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Text(
                text = "Thêm thẻ mới",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontFamily = FontFamily.Default,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAddPayment() {
    AddPaymentMethod()
}

