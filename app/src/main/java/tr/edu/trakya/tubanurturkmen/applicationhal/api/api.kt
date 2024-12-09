package tr.edu.trakya.tubanurturkmen.applicationhal.api

data class api(
    val BultenTarihi: String,
    val HalFiyatListesi: List<HalFiyatListesi>
)