package tr.edu.trakya.tubanurturkmen.applicationhal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tr.edu.trakya.tubanurturkmen.applicationhal.api.HalFiyatListesi
import tr.edu.trakya.tubanurturkmen.applicationhal.repository.HalRepository

class HalViewModel : ViewModel() {
    private val repository = HalRepository()

    private val _halFiyatlari = MutableStateFlow<List<HalFiyatListesi>>(emptyList())
    val halFiyatlari: StateFlow<List<HalFiyatListesi>> = _halFiyatlari

    init {
        fetchHalFiyatlari()
    }

    private fun fetchHalFiyatlari() {
        viewModelScope.launch {
            val response = repository.fetchHalFiyatlari()
            _halFiyatlari.value = response.HalFiyatListesi
        }
    }
}
