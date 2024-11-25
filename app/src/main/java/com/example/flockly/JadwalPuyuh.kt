package com.example.flockly

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ScheduleQuailPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5EDE1))
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Handle close action */ }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color(0xFF9C8062)
                )
            }
            Text(
                text = "Penjadwalan Puyuh",
//                style = MaterialTheme.typography.h6,
                color = Color.Black
            )
            IconButton(onClick = { /* Handle edit action */ }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit",
                    tint = Color(0xFF9C8062)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Quail Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.quail_image), // Replace with your image resource
                contentDescription = "Quail",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
//
//        // Input Fields
        ScheduleInputField(
            icon = ImageVector.vectorResource(id = R.drawable.calendar),
            label = "Tanggal",
            placeholder = "dd/mm/yy"
        )
//        Spacer(modifier = Modifier.height(8.dp))
//        ScheduleInputField(
//            icon = ImageVector.vectorResource(id = R.drawable.ic_clock),
//            label = "Jam & Pengingat",
//            placeholder = "08.00"
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        ScheduleInputField(
//            icon = ImageVector.vectorResource(id = R.drawable.ic_repeat),
//            label = "Ulangi Jadwal",
//            placeholder = "Yes / No"
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        ScheduleInputField(
//            icon = Icons.Default.Info,
//            label = "Keterangan",
//            placeholder = "Masukan"
//        )
//
//        Spacer(modifier = Modifier.weight(1f))
//
        // Save Button
        Button(
            onClick = { /* Handle save action */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C8062))
        ) {
            Text(text = "Simpan", color = Color.White)
        }
    }
}

@Composable
fun ScheduleInputField(icon: ImageVector, label: String, placeholder: String) {
    Column {
        Text(
            text = label,
//            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFE0D2C1))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(0xFF9C8062)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = placeholder,
//                style = MaterialTheme.typography.body1,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScheduleQuailPagePreview() {
    ScheduleQuailPage()
}