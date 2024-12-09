package tr.edu.trakya.tubanurturkmen.applicationhal

import HalFiyatListesiScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModel

import tr.edu.trakya.tubanurturkmen.applicationhal.viewmodel.HalViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HalFiyatListesiScreen(viewModel = HalViewModel())
        }
    }
}
