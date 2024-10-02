package com.example.fdev.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

// Data class cho response từ server
data class ProductResponse(
    @SerializedName("userId") val userId: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("type") val type: String,
)

// Data class cho request body gửi lên server
data class ProductRequest(
    val userId: String,
    val name: String,
    val price: String,
    val description: String,
    val image : String,
    val type: String,
)

// Data class cho đối tượng Product

data class Product(
    val userId: String,
    val name: String,
    val price: String,
    val description: String,
    val image : String,
    val type: String,
): Serializable


// Chuyển từ ProductResponse sang Product
fun ProductResponse.toProduct(): Product {
    return Product(
        userId = this.userId,
        name = this.name,
        price = this.price,
        description = this.description,
        image = this.image,
        type = this.type
    )
}

// Form data cho UI để tương tác với người dùng
data class ProductFormData(
    var userId : String = "",
    var name: String = "",
    var price: String = "",
    var description: String = "",
    var image: String = "",
    var type: String = "",
)

// Chuyển từ FormData thành Request để gửi lên server
fun ProductFormData.toProductRequest(): ProductRequest {
    return ProductRequest(
        userId = this.userId,
        name = this.name,
        price = this.price,
        description = this.description,
        image =  this.image,
        type = this.type
    )
}

// Chuyển đổi từ Product sang FormData
fun Product?.toProductFormData() = this?.let {
    ProductFormData(
        userId = this.userId,
        name = this.name,
        price = this.price,
        description = this.description,
        image = this.image,
        type = this.type
    )
}

