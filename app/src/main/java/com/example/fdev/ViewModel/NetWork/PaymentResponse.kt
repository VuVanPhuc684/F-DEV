package com.example.fdev.ViewModel.NetWork


data class PaymentResponse(
    val status: Int,
    val message: String,
    val data: List<PaymentData>
)

data class PaymentData(
    val id: String,
    val userId: String,
    val cardNumber: String,
    val nameOnCard: String,
    val expiryMonth: Int,
    val expiryYear: Int,
    val isActive: Boolean,
    val type: String,
    val cardType: String,
    val bankName: String,
    val billingAddress: BillingAddress
)