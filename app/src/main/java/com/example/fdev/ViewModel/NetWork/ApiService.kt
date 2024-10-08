package com.example.fdev.ViewModel.NetWork

import com.example.fdev.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    //===========GET===========

    // Lấy danh sách các liên hệ (Contact)
    @GET("/contact/get-list-Contact")
    suspend fun getContactList(): Response<List<ContactMailResponse>>

    // Lấy danh sách các sản phẩm (Product)
    @GET("/product/get-list-Product")
    suspend fun getProductList(): Response<List<ProductResponse>>

    // Lấy giỏ hàng dựa trên tên người dùng
    @GET("/cart/get-list-cart")
    suspend fun getCart(@Query("userName") userName: String): Response<CartResponse> // Thay userEmail thành userName

    // Tìm kiếm sản phẩm theo tên
    @GET("/product/search-product")
    suspend fun searchProduct(
        @Query("name") name: String
    ): Response<List<ProductResponse>>

    //===========POST===========
    // Thêm sản phẩm vào giỏ hàng
    @POST("/cart/add-to-cart")
    suspend fun addToCart(@Body request: AddToCartRequest): Response<CartResponse>


    // Gửi dữ liệu liên hệ mới (Contact) lên server
    @POST("/contact/post-list-Contact")
    suspend fun createContact(
        @Body contact: ContactMailRequest
    ): Response<ContactMailResponse>

    //===========DELETE===========
    // Xóa sản phẩm khỏi giỏ hàng
    @DELETE("/cart/remove-from-cart")
    suspend fun removeFromCart(
        @Query("userName") userName: String, // Thay userEmail thành userName
        @Query("productId") productId: String
    ): Response<CartResponse>
}
