package com.example.front_end

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_end.ui.theme.Front_EndTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilKandang() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFEBF0EC)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Kandang Ayam",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Aksi Kembali */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back1),
                            contentDescription = "Kembali",
                            tint = Color.Black,
                            modifier = Modifier.size(35.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFFEBF0EC))
            )

            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFD6C3A3), RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
                    .padding(20.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Profil Kandang",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.splash2),
                        contentDescription = "Gambar kandang ayam",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(bottom = 10.dp),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {
                        ProfileItem(label = "Nama Kandang", value = "Kandang Ayam")
                        ProfileItem(label = "Alamat", value = "Cipondoh RT 010/004")
                        ProfileItem(label = "Kota/Kabupaten", value = "Tangerang")
                        ProfileItem(label = "Kapasitas Kandang", value = "5 ekor")
                        ProfileItem(label = "Jenis Kandang", value = "Close House")
                        ProfileItem(label = "Keterangan", value = "-")
                    }

                    Spacer(modifier = Modifier.height(60.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = { /* TODO: Edit action */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F4A43)),
                            modifier = Modifier.weight(0.7f)
                        ) {
                            Text(text = "Edit", color = Color.White)
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Button(
                            onClick = { /* TODO: Jadwal Bersih action */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F4A43)),
                            modifier = Modifier.weight(0.7f)
                        ) {
                            Text(text = "Jadwal Bersih", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileItem(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        Text(text = value, fontSize = 15.sp, fontWeight = FontWeight.Normal)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilKandangPreview() {
    Front_EndTheme {
        ProfilKandang()
    }
}
