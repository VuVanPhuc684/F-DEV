package com.example.fdev.ViewModel

import RetrofitService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fdev.model.ReviewResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ReviewViewModel : ViewModel() {

    private val _reviews = MutableStateFlow<List<ReviewResponse>>(emptyList())
    val reviews: StateFlow<List<ReviewResponse>> get() = _reviews

    private val _errorMessage = MutableStateFlow<String>("")
    val errorMessage: StateFlow<String> get() = _errorMessage

    private val apiService = RetrofitService().fdevApiService

    fun fetchReviews(productId: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getReviews(productId)
                if (response.isSuccessful && response.body() != null) {
                    _reviews.value = response.body() ?: emptyList()
                } else {
                    _errorMessage.value = "Failed to fetch reviews. Error: ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching reviews: ${e.message}"
            }
        }
    }
}
