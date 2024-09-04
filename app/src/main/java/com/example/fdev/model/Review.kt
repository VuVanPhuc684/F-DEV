package com.example.fdev.model

import com.example.fdev.R
import com.example.fdev.View.Review

data class Review(
    val reviewerName: String,
    val reviewDate: String,
    val rating: Int,
    val reviewText: String,
    val reviewerImageRes: Int
)

