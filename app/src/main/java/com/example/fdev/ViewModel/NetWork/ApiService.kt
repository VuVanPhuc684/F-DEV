package com.example.fdev.ViewModel.NetWork

import com.example.fdev.model.ContactMailRequest
import com.example.fdev.model.ContactMailResponse
import com.example.fdev.model.ProductResponse
import com.example.fdev.model.ReviewRespone
import com.example.fdev.model.ReviewResponeProduct
import com.example.fdev.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    //===========GET===========

    // Lấy danh sách các liên hệ (Contact)
    @GET("/contact/get-list-Contact")
    suspend fun getContactList(): Response<List<ContactMailResponse>>

    // Lấy danh sách các sản phẩm ( Product )
    @GET("/product/get-list-Product")
    suspend fun getProductList(): Response<List<ProductResponse>>

    // Lấy giỏ hàng dựa trên tên người dùng
    @GET("/cart/get-list-cart")
    suspend fun getCart(@Query("userName") userName: String): Response<CartResponse>

    @GET("/favourite/get-list-favourite")
    suspend fun getFavourite(@Query("userName") userName: String): Response<FavouriteResponse>

    // Tìm kiếm sản phẩm theo tên
    @GET("/product/search-product")
    suspend fun searchProduct(@Query("name") name: String): Response<List<ProductResponse>>

    // Lấy tất cả danh sách review
    @GET("/review/get-list-Review")
    suspend fun getReviewList(): Response<List<ReviewRespone>>

    // Lấy Review theo Product
    @GET("/get-reviews/:productId")
    suspend fun getReviewProduct(): Response<List<ReviewResponeProduct>>


    //===========POST===========
    // Thêm sản phẩm vào giỏ hàng
    @POST("/cart/add-to-cart")
    suspend fun addToCart(@Body request: AddToCartRequest): Response<CartResponse>

    // Thêm sản phẩm vào yêu thích
    @POST("/favourite/add-to-favourite")
    suspend fun addToFavourite(@Body request: AddToFavouriteRequest): Response<FavouriteResponse>

    // Gửi dữ liệu liên hệ mới (Contact) lên server
    @POST("/contact/post-list-Contact")
    suspend fun createContact(@Body contact: ContactMailRequest): Response<ContactMailResponse>

    //===========DELETE===========
    // Xóa sản phẩm khỏi giỏ hàng
    @DELETE("/cart/remove-from-cart/{userName}/{productName}")
    suspend fun removeFromCart(@Path("userName") userName: String, @Path("productName") productName: String): Response<CartResponse>

    @DELETE("/favourite/remove-from-favourite/{userName}/{productName}")
    suspend fun removeFromFavourite(@Path("userName") userName: String, @Path("productName") productName: String): Response<FavouriteResponse>
}


