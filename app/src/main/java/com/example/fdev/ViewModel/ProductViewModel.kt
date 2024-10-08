package com.example.fdev.ViewModel

import RetrofitService
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fdev.model.Product
import com.example.fdev.model.ProductResponse
import com.example.fdev.model.toProduct
import kotlinx.coroutines.launch

import retrofit2.Response

class ProductViewModel(private val retrofitService: RetrofitService) : ViewModel() {

    var productList = mutableStateOf<List<Product>>(listOf())
        private set

    fun fetchProductList() {
        viewModelScope.launch {
            try {
                val response: Response<List<ProductResponse>> = retrofitService.fdevApiService.getProductList()
                if (response.isSuccessful) {
                    response.body()?.let { productResponses ->
                        productList.value = productResponses.map { it.toProduct() }
                    }
                } else {
                    if (!response.isSuccessful) {
                        Log.e("ProductViewModel", "Lỗi từ server: ${response.code()} - ${response.message()}")
                    }
                }
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Lỗi khi gọi API: ${e.message}", e)
            }
        }
    }
}