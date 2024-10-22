package com.example.fdev.model

data class ReviewResponse(
    val userName: String,
    val comment: String,
    val rating: Int,
    val createdAt: String,
    val productDetails: ProductDetails
)

data class ProductDetails(
    val name: String,
    val price: Double,
    val description: String
)
