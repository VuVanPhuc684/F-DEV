package com.example.fdev.View


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fdev.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("The Pets Table")) }

    val searchResults = listOf(
        SearchItem(
            title = "The Pets Table",
            price = 50.00,
            imageRes = R.drawable.anh2 // Ensure you use a valid drawable resource ID here
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { /* Handle back navigation */ }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.headlineSmall,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(5f)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(Color.White, RoundedCornerShape(50.dp)), // Correct the background usage
                shape = RoundedCornerShape(50.dp),
                placeholder = { Text(text = "Search...") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray
                )
            )

            Text(
                text = "Result for \"${searchQuery.text}\"",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
            )
            Divider(color = Color.Gray, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                // Correctly using the list of search results
                items(searchResults) { item: SearchItem -> // Ensure you are iterating over SearchItem, not Int
                    SearchResultItem(item)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun SearchResultItem(item: SearchItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = item.title,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "$ ${item.price}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.Black
                )
            )
        }
    }
}

data class SearchItem(
    val title: String,
    val price: Double,
    val imageRes: Int // This should be an Int representing the drawable resource ID
)

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = rememberNavController())
}
