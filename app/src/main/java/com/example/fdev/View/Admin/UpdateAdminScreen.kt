package com.example.fdev.View.Admin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fdev.R

@Composable
fun UpdateProductScreenAdmin() {
    var productName by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productImageUrl by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(20.dp, top = 65.dp, end = 20.dp)
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
                text = "UPDATE PRODUCT",
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

        Spacer(modifier = Modifier.height(20.dp))

        // Product Name
        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text("Product") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Product Price
        OutlinedTextField(
            value = productPrice,
            onValueChange = { productPrice = it },
            label = { Text("Price") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Product Description
        OutlinedTextField(
            value = productDescription,
            onValueChange = { productDescription = it },
            label = { Text("Describe") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 4
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Product Image URL
        OutlinedTextField(
            value = productImageUrl,
            onValueChange = { productImageUrl = it },
            label = { Text("Image") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(52.dp))

        // Save Button
        Button(
            onClick = {
                // Xử lý khi bấm nút Save, có thể gửi dữ liệu lên server
                println("Product Saved: $productName, $productPrice, $productDescription, $productImageUrl")
            },
            modifier = Modifier.size(290.dp, 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff242424)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "SAVE PRODUCT",
                fontSize = 16.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UpdateProductScreenPreview() {
    UpdateProductScreenAdmin()
}