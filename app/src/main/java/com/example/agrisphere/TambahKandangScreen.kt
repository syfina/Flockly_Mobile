package com.example.agrisphere


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agrisphere.ui.theme.AgrisphereTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKandangScreen() {
    var namaKandang by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var kota by remember { mutableStateOf("") }
    var populasiby remember { mutableStateOf("") }
    var jenisKandang by remember { mutableStateOf("") }
    var keterangan by remember { mutableStateOf("") }
    var isKotaDropdownExpanded by remember { mutableStateOf(false) }
    var isJenisDropdownExpanded by remember { mutableStateOf(false) }

    val kotaOptions = listOf("Jakarta", "Bandung", "Surabaya")
    val jenisOptions = listOf("Terbuka", "Tertutup")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(colorResource(R.color.bg_color))
    ) {
        Text(
            text = "Tambah Kandang Baru",
            fontSize = 20.sp,
            color = colorResource(R.color.color1),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(
            value = namaKandang,
            onValueChange = { namaKandang = it },
            label = { Text(
                text = "Nama Kandang",
                color = colorResource(id = R.color.color2)
            ) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.color2),
                unfocusedBorderColor = colorResource(id = R.color.color3)
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat",
                color = colorResource(id = R.color.color2)) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.color2),
                unfocusedBorderColor = colorResource(id = R.color.color3)
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = kota,
                onValueChange = {},
                label = { Text("Kota", color = colorResource(id = R.color.color2)) },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.clickable { isKotaDropdownExpanded = true },
                        tint = colorResource(id = R.color.color2)
                    )
                },
                enabled = false,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.color2),
                    unfocusedBorderColor = colorResource(id = R.color.color4),
                )
            )
            DropdownMenu(
                expanded = isKotaDropdownExpanded,
                onDismissRequest = { isKotaDropdownExpanded = false }
            ) {
                kotaOptions.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            kota = option
                            isKotaDropdownExpanded = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = option,
                            color = colorResource(R.color.black))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = populasiby,
            onValueChange = { populasiby = it },
            label = { Text("Jumlah Populasi (ekor)", color = colorResource(R.color.color2)) },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(R.color.color2),
                unfocusedBorderColor = colorResource(R.color.color4)
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = jenisKandang,
                onValueChange = {},
                label = { Text("Jenis Kandang", color = colorResource(R.color.color2)) },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.clickable { isJenisDropdownExpanded = true },
                        tint = colorResource(R.color.color2)
                    )
                },
                enabled = false,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(R.color.color2),
                    unfocusedBorderColor = colorResource(R.color.color4)
                )
            )
            DropdownMenu(
                expanded = isJenisDropdownExpanded,
                onDismissRequest = { isJenisDropdownExpanded = false }
            ) {
                jenisOptions.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            jenisKandang = option
                            isJenisDropdownExpanded = false
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = option,
                            color = colorResource(id = R.color.black)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = keterangan,
            onValueChange = { keterangan = it },
            label = { Text("Keterangan", color = colorResource(R.color.color2)) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(R.color.color2),
                unfocusedBorderColor = colorResource(R.color.color4)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(colorResource(R.color.color6), RoundedCornerShape(8.dp))
                .clickable { /* Handle upload photo */ },
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.CloudUpload,
                    contentDescription = "Unggah Foto",
                    tint = colorResource(R.color.color4),
                    modifier = Modifier.size(48.dp)
                )
                Text(text = "Unggah Foto", color = colorResource(R.color.color4))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Handle save logic here
                Toast.makeText(it.context, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color1)
        ) {
            Text(
                text = "Simpan",
                color = White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TambahKandangPreview() {
    AgrisphereTheme {
        TambahKandangScreen()
    }
}