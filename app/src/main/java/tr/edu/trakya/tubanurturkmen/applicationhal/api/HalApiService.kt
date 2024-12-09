package tr.edu.trakya.tubanurturkmen.applicationhal.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Retrofit API Arayüzü
interface HalApiService {
    @GET("api/ibb/halfiyatlari/sebzemeyve/2024-12-06")
    suspend fun getHalFiyatListesi(): ApiResponse
}

// Retrofit Servis (Singleton Instance)
object RetrofitInstance {
    private const val BASE_URL = "https://openapi.izmir.bel.tr/"

    val api: HalApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HalApiService::class.java)
    }
}
