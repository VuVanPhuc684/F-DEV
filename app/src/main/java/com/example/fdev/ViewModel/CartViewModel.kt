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

    // Hàm lấy giỏ hàng từ MongoDB qua API
    fun getCartItems() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userName = currentUser?.displayName ?: ""  // Lấy tên người dùng từ Firebase

        if (userName.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val response = apiService.getCart(userName)
                    if (response.isSuccessful) {
                        response.body()?.let { cartResponse ->
                            _cartItems.value = cartResponse.data.products.mapNotNull { cartProduct ->
                                CartItem(
                                    product = cartProduct.product.id ?: "",  // ID sản phẩm
                                    name = cartProduct.name ?: "Unknown Product",  // Tên sản phẩm
                                    price = cartProduct.price ?: 0.0,  // Giá sản phẩm
                                    image = cartProduct.image ?: ""  // Ảnh sản phẩm
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
        }
    }

    // Thêm sản phẩm vào giỏ hàng và cập nhật UI
    fun addToCart(product: Product, quantity: Int = 1) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userName = currentUser?.displayName ?: ""

        if (userName.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val request = AddToCartRequest(userName, product.id, quantity)
                    val response = apiService.addToCart(request)
                    if (response.isSuccessful) {
                        _cartItems.value = _cartItems.value + CartItem(
                            product = product.id,
                            name = product.name,
                            price = product.price,
                            image = product.image
                        )
                    } else {
                        Log.e("CartViewModel", "Error adding to cart: ${response.code()} - ${response.message()}")
                    }
                } catch (e: Exception) {
                    Log.e("CartViewModel", "API call failed: ${e.message}", e)
                }
            }
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng và cập nhật UI
    fun removeFromCart(productId: String) {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userName = currentUser?.displayName ?: ""

        if (userName.isNotBlank()) {
            viewModelScope.launch {
                try {
                    val response = apiService.removeFromCart(userName, productId)
                    if (response.isSuccessful) {
                        _cartItems.value = _cartItems.value.filter { it.product != productId }
                    } else {
                        Log.e("CartViewModel", "Error removing from cart: ${response.code()} - ${response.message()}")
                    }
                } catch (e: Exception) {
                    Log.e("CartViewModel", "API call failed: ${e.message}", e)
                }
            }
        }
    }

    // Tính tổng giá trị giỏ hàng
    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.price.toDouble() }
    }
}

