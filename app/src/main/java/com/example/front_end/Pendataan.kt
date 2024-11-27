package com.example.front_end

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_end.ui.theme.Front_EndTheme

@Composable
fun Pendataan() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F5EE))
            .padding(20.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 50.dp)
        ) {
            IconButton(onClick = { /* TODO: Add back button action */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.back1),
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.width(80.dp))
            Text(
                text = "Pendataan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            MenuButton("Daftar Ternak", R.drawable.daftarternak)
            MenuButton("Hasil Produksi", R.drawable.hasilproduksi)
            MenuButton("Konsumsi Pakan", R.drawable.konsumsipakan)
            MenuButton("Pendapatan", R.drawable.pendapatan)
            MenuButton("Biaya Operasional", R.drawable.biayaoperasional)
        }
    }
}

@Composable
fun MenuButton(text: String, iconResId: Int) {
    Button(
        onClick = { /* TODO: Handle button click */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4B3A2F)),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(35.dp)
                    .align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = text,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PendataanPreview() {
    Front_EndTheme {
        Pendataan()
    }
}
