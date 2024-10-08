package com.example.fdev.model

// Data GET Review từ API
data class ReviewRespone(
    val _id: String,
    val productId: String,
    val userId: String,
    val rate: Int,
    val comment: String,
    val time: String?
)

// Data GET Review theo Product
data class ReviewResponeProduct(
    val productId: String,
    val userId: String,
    val rate: Int,
    val comment: String
)