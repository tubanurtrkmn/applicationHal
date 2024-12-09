package tr.edu.trakya.tubanurturkmen.applicationhal.repository

import tr.edu.trakya.tubanurturkmen.applicationhal.api.ApiResponse
import tr.edu.trakya.tubanurturkmen.applicationhal.api.RetrofitInstance

class HalRepository {
    suspend fun fetchHalFiyatlari(): ApiResponse {
        return RetrofitInstance.api.getHalFiyatListesi()
    }
}
