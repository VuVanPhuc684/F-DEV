package com.example.fdev.model

data class Review(
    val reviewerName: String,
    val reviewDate: String,
    val rating: Int,
    val reviewText: String,
    val reviewerImageRes: Int,
)

