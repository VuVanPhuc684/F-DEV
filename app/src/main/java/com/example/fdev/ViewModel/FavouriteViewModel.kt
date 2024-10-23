//import android.util.Log
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.fdev.View.FavouriteItem
//import com.example.fdev.ViewModel.NetWork.ApiService
//import com.example.fdev.model.AddToCartRequest
//import com.example.fdev.model.AddToFavouriteRequest
//import com.example.fdev.model.Favourite
//import com.example.fdev.model.Product
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import com.google.firebase.auth.FirebaseAuth
//
//class FavouriteViewModel() : ViewModel() {
//    private val apiService = RetrofitService().fdevApiService
//    private val _favouriteItems = MutableStateFlow<List<FavouriteItem>>(emptyList())
//    val favouriteItems: StateFlow<List<FavouriteItem>> = _favouriteItems
//
//    // Hàm lấy danh sách yêu thích từ API
//    fun getFavouriteItems() {
//        val currentUser = FirebaseAuth.getInstance().currentUser
//        val userName = currentUser?.displayName ?: ""  // Lấy tên người dùng từ Firebase
//
//        if (userName.isNotBlank()) {
//            viewModelScope.launch {
//                try {
//                    val response = apiService.getFavourite(userName)  // Thay đổi apiService với hàm lấy yêu thích
//                    if (response.isSuccessful) {
//                        response.body()?.let { favouriteResponse ->
//                            _favouriteItems.value = favouriteResponse.data.products.mapNotNull { favouriteProduct ->
//                                    FavouriteItem(
//                                        product = favouriteProduct.product.id ?: "",  // ID sản phẩm
//                                        name = favouriteProduct.name
//                                            ?: "Unknown Product",  // Tên sản phẩm
//                                        price = favouriteProduct.price ?: 0.0,  // Giá sản phẩm
//                                        image = favouriteProduct.image ?: ""  // Ảnh sản phẩm
//                                    )
//                                }
//                        }
//                    } else {
//                        Log.e("FavouriteViewModel", "Error getting favourites: ${response.code()} - ${response.message()}")
//                    }
//                } catch (e: Exception) {
//                    Log.e("FavouriteViewModel", "API call failed: ${e.message}", e)
//                }
//            }
//        }
//    }
//
//    fun addToFavourite(product: Product, quantity: Int = 1) {
//        val currentUser = FirebaseAuth.getInstance().currentUser
//        val userName = currentUser?.displayName ?: ""
//
//        if (userName.isNotBlank()) {
//            viewModelScope.launch {
//                try {
//                    val request = AddToFavouriteRequest(userName, product.id, quantity)
//                    val response = apiService.addToFavourite(request)
//                    if (response.isSuccessful) {
//                        _favouriteItems.value = _favouriteItems.value + FavouriteItem(
//                            product = product.id,
//                            name = product.name,
//                            price = product.price,
//                            image = product.image
//                        )
//                    } else {
//                        Log.e("CartViewModel", "Error adding to cart: ${response.code()} - ${response.message()}")
//                    }
//                } catch (e: Exception) {
//                    Log.e("CartViewModel", "API call failed: ${e.message}", e)
//                }
//            }
//        }
//    }
//
//
//
//    // Hàm xóa sản phẩm khỏi danh sách yêu thích
//    fun removeFromFavourites(productName: String): Boolean {
//        val currentUser = FirebaseAuth.getInstance().currentUser
//        val userName = currentUser?.displayName ?: ""
//
//        if (userName.isNotBlank()) {
//            var isRemoved = false  // Biến để kiểm tra xem sản phẩm có được xóa hay không
//            viewModelScope.launch {
//                try {
//                    val response = apiService.removeFromFavourite(userName, productName)  // Thay đổi apiService
//                    if (response.isSuccessful) {
//                        _favouriteItems.value = _favouriteItems.value.filter { it.name != productName }
//                        isRemoved = true  // Đánh dấu là xóa thành công
//                    } else {
//                        Log.e("FavouriteViewModel", "Error removing from favourites: ${response.code()} - ${response.message()}")
//                    }
//                } catch (e: Exception) {
//                    Log.e("FavouriteViewModel", "API call failed: ${e.message}", e)
//                }
//            }
//            return isRemoved
//        }
//        return false
//    }
//}
