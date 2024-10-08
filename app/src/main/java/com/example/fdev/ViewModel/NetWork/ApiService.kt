package com.example.fdev.ViewModel.NetWork

import com.example.fdev.model.ContactMailRequest
import com.example.fdev.model.ContactMailResponse
import com.example.fdev.model.ProductResponse
import com.example.fdev.model.ReviewRespone
import com.example.fdev.model.ReviewResponeProduct
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    //===========GET===========

    // Lấy danh sách các liên hệ (Contact)
    @GET("/contact/get-list-Contact")
    suspend fun getContactList(): Response<List<ContactMailResponse>>

    // Lấy danh sách các sản phẩm ( Product )
    @GET("/product/get-list-Product")
    suspend fun getProductList(): Response<List<ProductResponse>>

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

    // Gửi dữ liệu liên hệ mới (Contact) lên server
    @POST("/contact/post-list-Contact")
    suspend fun createContact(@Body contact: ContactMailRequest): Response<ContactMailResponse>

}

