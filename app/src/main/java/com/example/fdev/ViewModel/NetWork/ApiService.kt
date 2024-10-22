package com.example.fdev.ViewModel.NetWork

import com.example.fdev.model.*
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/contact/get-list-Contact")
    suspend fun getContactList(): Response<List<ContactMailResponse>>

    @GET("/product/get-list-Product")
    suspend fun getProductList(): Response<List<ProductResponse>>

    @GET("/cart/get-list-cart")
    suspend fun getCart(@Query("userName") userName: String): Response<CartResponse>

    @GET("/favourite/get-list-favourite")
    suspend fun getFavourite(@Query("userName") userName: String): Response<FavouriteResponse>

    @GET("/product/search-product")
    suspend fun searchProduct(@Query("name") name: String): Response<List<ProductResponse>>

    @POST("/cart/add-to-cart")
    suspend fun addToCart(@Body request: AddToCartRequest): Response<CartResponse>

    // Thêm sản phẩm vào yêu thích
    @POST("/favourite/add-to-favourite")
    suspend fun addToFavourite(@Body request: AddToFavouriteRequest): Response<FavouriteResponse>

    // Gửi dữ liệu liên hệ mới (Contact) lên server
    @POST("/contact/post-list-Contact")
    suspend fun createContact(@Body contact: ContactMailRequest): Response<ContactMailResponse>

    @DELETE("/cart/remove-from-cart/{userName}/{productName}")
    suspend fun removeFromCart(@Path("userName") userName: String, @Path("productName") productName: String): Response<CartResponse>

    // hiển thị comment
    @GET("/review/get-reviews/{productId}")
    suspend fun getReviews(@Path("productId") productId: String): Response<List<ReviewResponse>>

    @POST("/review/add-review")
    suspend fun addReview(@Body reviewRequest: ReviewRequest): Response<ReviewResponse>
    //===========DELETE===========


    @DELETE("/favourite/remove-from-favourite/{userName}/{productName}")
    suspend fun removeFromFavourite(@Path("userName") userName: String, @Path("productName") productName: String): Response<FavouriteResponse>

}
