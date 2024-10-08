package com.example.fdev.ViewModel

import RetrofitService
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fdev.ViewModel.NetWork.ApiService

import com.example.fdev.model.ReviewRespone
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ReviewViewModel : ViewModel() {
    private val _reviewList = MutableStateFlow<List<ReviewRespone>>(emptyList())
    val reviewList: StateFlow<List<ReviewRespone>> = _reviewList

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val apiService: ApiService = RetrofitService().fdevApiService

    // Lấy danh sách review từ API
    fun fetchReviews() {
        viewModelScope.launch {
            try {
                val response = apiService.getReviewList()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _reviewList.value = it
                    }
                } else {
                    _errorMessage.value = "Lỗi khi lấy dữ liệu từ API: ${response.code()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Lỗi kết nối: ${e.localizedMessage}"
            }
        }
    }
}
