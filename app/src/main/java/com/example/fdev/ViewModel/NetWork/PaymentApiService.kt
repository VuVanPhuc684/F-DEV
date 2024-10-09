package com.example.fdev.ViewModel.NetWork

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class PaymentRequest(
    val userId: String,
    val cardNumber: String,
    val nameOnCard: String,
    val expiryMonth: Int,
    val expiryYear: Int,
    val type: String,
    val cardType: String,
    val bankName: String,
    val billingAddress: BillingAddress,
    val image: String?
)

data class BillingAddress(
    val street: String,
    val city: String,
    val postalCode: String,
    val country: String
)

interface PaymentApiService {
    @POST("payment")
    fun addPayment(@Body payment: PaymentRequest): Call<PaymentResponse>

    @GET("payment/{userId}")
    fun getPayments(@Path("userId") userId: String): Call<PaymentResponse>
}
