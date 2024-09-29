package com.example.fdev.ViewModel.NetWork

import com.example.fdev.model.ContactMailRequest
import com.example.fdev.model.ContactMailResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    //===========GET===========

    // Lấy danh sách các liên hệ (Contact)
    @GET("/contact/get-list-Contact")
    suspend fun getContactList(): Response<List<ContactMailResponse>>

    //===========POST===========

    // Gửi dữ liệu liên hệ mới (Contact) lên server
    @POST("/contact/post-list-Contact")
    suspend fun createContact(@Body contact: ContactMailRequest): Response<ContactMailResponse>


}

