package com.example.fdev.ViewModel.data

import com.example.fdev.R
import com.example.fdev.model.Profile
import com.example.fdev.View.MainActivity.Router

val setingItem = listOf(
    Profile("Đơn hàng của tôi", "Đã có 10 đơn hàng", R.drawable.right_black, Router.CART.name),
    Profile("Phương thức thanh toán", "Bạn có 02 thẻ", R.drawable.right_black, Router.PAYMENTMETHODSCREEN.name),
    Profile("Đánh giá của tôi", "Có 5 bài đánh giá", R.drawable.right_black, Router.REVIEW.name),
    Profile("Cài đặt", "Thông báo, Mật khẩu, FAQ, Liên hệ,...", R.drawable.right_black, Router.SETTING.name),
    Profile("Ngôn Ngữ", "Thay đổi ngôn ngữ", R.drawable.right_black, Router.LANGUAGE.name),
)
