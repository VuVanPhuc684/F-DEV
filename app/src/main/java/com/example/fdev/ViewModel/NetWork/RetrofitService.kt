import com.example.fdev.ViewModel.NetWork.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitService {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.53.103:3001/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val fdevApiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
