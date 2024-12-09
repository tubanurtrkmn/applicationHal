package tr.edu.trakya.tubanurturkmen.applicationhal.api

data class HalFiyatListesi(
    val AsgariUcret: Int,
    val AzamiUcret: Int,
    val Birim: String,
    val Gorsel: String,
    val HalTuru: Int,
    val MalAdi: String,
    val MalId: Int,
    val MalTipAdi: String,
    val MalTipId: Int,
    val OrtalamaUcret: Double,
    val tarih: Any
)
data class ApiResponse(
    val BultenTarihi: String,
    val HalFiyatListesi: List<HalFiyatListesi>
)