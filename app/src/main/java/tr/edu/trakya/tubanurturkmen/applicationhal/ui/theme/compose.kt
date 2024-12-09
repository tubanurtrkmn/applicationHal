import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import tr.edu.trakya.tubanurturkmen.applicationhal.api.HalFiyatListesi
import tr.edu.trakya.tubanurturkmen.applicationhal.viewmodel.HalViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalFiyatListesiScreen(viewModel: HalViewModel) {
    val halFiyatlari by viewModel.halFiyatlari.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val filteredList = halFiyatlari.filter {
        it.MalAdi.contains(searchQuery, ignoreCase = true)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Arama Çubuğu
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            label = { Text("Ara: Mal Adı") },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFEDEDED),
                focusedIndicatorColor = Color(0xFF6200EE),
                unfocusedIndicatorColor = Color(0xFFC2C2C2)
            )
        )

        // Liste
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(filteredList.size) { index ->
                val item = filteredList[index]
                HalFiyatItem(item)
            }
        }
    }
}

@Composable
fun HalFiyatItem(item: HalFiyatListesi) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ürün Görseli
            Image(
                painter = rememberAsyncImagePainter(item.Gorsel),
                contentDescription = "Görsel",
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.LightGray, CircleShape)
                    .padding(4.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Ürün Bilgileri
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = item.MalAdi,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Ortalama Ücret: ${item.OrtalamaUcret} ${item.Birim}",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Azami Ücret: ${item.AzamiUcret} ${item.Birim}",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
                Text(
                    text = "Asgari Ücret: ${item.AsgariUcret} ${item.Birim}",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}
