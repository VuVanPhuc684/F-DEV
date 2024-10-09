package com.example.fdev.model

data class AddToCartRequest(
    val userName: String,
    val productId: String,
    val quantity: Int
)

data class CartResponse(
    val status: Int,
    val msg: String,
    val data: Cart
)

data class Cart(
    val userName: String,
    val products: List<CartProduct>
)

data class CartProduct(
    val product: Product,
    val quantity: Int,
    val price: Double,
    val name: String,
    val image: String
)

