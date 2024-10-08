package com.example.fdev.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fdev.ViewModel.NetWork.ApiService
import com.example.fdev.model.AddToCartRequest
import com.example.fdev.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.google.firebase.auth.FirebaseAuth

class CartViewModel(private val apiService: ApiService) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    // Lấy danh sách sản phẩm trong giỏ hàng theo tên người dùng
    fun getCartItems() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userName = currentUser?.displayName ?: "" // Lấy tên người dùng từ Firebase

        if (userName.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val response = apiService.getCart(userName) // Gọi API với tên người dùng
                    if (response.isSuccessful) {
                        response.body()?.let { cartResponse ->
                            _cartItems.value = cartResponse.data.products.map { cartProduct ->
                                CartItem(
                                    product = cartProduct.product.id,
                                    name = cartProduct.name,
                                    price = cartProduct.price,
                                    image = cartProduct.image
                                )
                            }
                        }
                    } else {
                        Log.e("CartViewModel", "Error getting cart: ${response.code()} - ${response.message()}")
                    }
                } catch (e: Exception) {
                    Log.e("CartViewModel", "API call failed: ${e.message}", e)
                }
            }
        } else {
            Log.e("CartViewModel", "User name is empty.")
        }
    }

    // Thêm sản phẩm vào giỏ hàng
    fun addToCart(product: Product, userName: String, quantity: Int = 1) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userName = currentUser?.displayName ?: "" // Lấy tên người dùng từ Firebase
        if (userName.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val request = AddToCartRequest(userName, product.id, quantity) // Sử dụng userName
                    val response = apiService.addToCart(request)
                    if (response.isSuccessful) {
                        getCartItems() // Cập nhật lại giỏ hàng sau khi thêm
                    } else {
                        Log.e("CartViewModel", "Error adding to cart: ${response.code()} - ${response.message()}")
                    }
                } catch (e: Exception) {
                    Log.e("CartViewModel", "API call failed: ${e.message}", e)
                }
            }
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    fun removeFromCart(productId: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userName = currentUser?.displayName ?: "" // Lấy tên người dùng từ Firebase
        viewModelScope.launch {
            try {
                val response = apiService.removeFromCart(userName, productId) // Sử dụng userName
                if (response.isSuccessful) {
                    getCartItems() // Cập nhật lại giỏ hàng sau khi xóa
                } else {
                    Log.e("CartViewModel", "Error removing from cart: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("CartViewModel", "API call failed: ${e.message}", e)
            }
        }
    }

    // Hàm tính tổng giá trị giỏ hàng
    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.price }
    }
}
