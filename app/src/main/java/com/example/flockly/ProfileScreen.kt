package com.example.flockly

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flockly.ui.theme.FlocklyTheme

@Composable
fun ProfileScreen(
    backIconResource: Int,
    profileImageResource: Int,
    editIconResource: Int
) {
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFEBF0EC))) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(backIconResource),
                    contentDescription = "Back Icon",
                    modifier = Modifier.size(32.dp).clip(CircleShape).clickable { },
                    tint = Color(0xFF000000)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Profil",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        Box(modifier = Modifier.fillMaxSize().padding(top = 200.dp), contentAlignment = Alignment.TopCenter) {
            UserInfoCard(editIconResource)
            ProfileImage(profileImageResource, modifier = Modifier.align(Alignment.TopCenter).offset(y = (-60).dp))
        }

        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp).align(Alignment.BottomCenter)
                .background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color(0xFFD6C3A3))))
        )
    }
}

@Composable
fun ProfileImage(profileImageResource: Int, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(120.dp).clip(CircleShape).border(3.dp, Color(0xFF5F4A43), CircleShape)
                .background(Color.LightGray)
        ) {
            Image(
                painter = painterResource(id = profileImageResource),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(120.dp).clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Frans Rathore",
//                style = MaterialTheme.typography.h6,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "fransrathore18@gmail.com",
//                style = MaterialTheme.typography.body2,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(250.dp))
        Image(
            painter = painterResource(id = R.drawable.flockly_logo1),
            contentDescription = "Footer",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(90.dp))
        BottomNavigationBar()
    }
}

@Composable
fun UserInfoCard(editIconResource: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(0.90f).clip(RoundedCornerShape(40.dp))
            .background(Color(0xFFD6C3A3))
            .padding(top = 100.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        ProfileMenuItem(
            icon = Icons.Filled.AccountCircle,
            title = "Informasi Akun"
        ) {
            // Handle menu click
        }
        Divider(color = Color.Black, thickness = 2.dp)
        ProfileMenuItem(
            icon = Icons.Filled.Notifications,
            title = "Pengaturan Notifikasi"
        ) {

        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .shadow(elevation = 15.dp, shape = RoundedCornerShape(10.dp), ambientColor = Color.Gray, spotColor = Color.Black),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5F4A43))
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(painter = painterResource(id = editIconResource), contentDescription = "Edit Icon", tint = Color.White, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Keluar", color = Color.White)
            }
        }

    }

}

@Composable
fun ProfileMenuItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color(0xFF000000),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
//            style = MaterialTheme.typography.body1,
            color = Color.Black
        )
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier, currentPage: String = "Beranda", barWidth: Dp = 350.dp) {
    Row(
        modifier = modifier
            .width(barWidth)
            .background(Color(0xFF5F4A43), RoundedCornerShape(35.dp))
            .padding(horizontal = 2.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomNavItem(
            text = "Beranda",
            iconRes = R.drawable.beranda,
            isSelected = currentPage == "Beranda",
            onClick = {}
        )
        BottomNavItem(
            text = "Statistik",
            iconRes = R.drawable.statistik,
            isSelected = currentPage == "Statistik",
            onClick = {}
        )
        BottomNavItem(
            text = "Profil",
            iconRes = R.drawable.profil,
            isSelected = currentPage == "Profil",
            onClick = {}
        )
    }
}



@Composable
fun BottomNavItem(text: String, iconRes: Int, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            tint = if (isSelected) Color.White else Color(0xFFCED9D5),
            modifier = Modifier
                .size(35.dp)
                .clickable { onClick() }
        )
        Text(
            text = text,
            fontSize = 15.sp,
            color = if (isSelected) Color.White else Color(0xFFCED9D5)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InformasiAkunPreview() {
    FlocklyTheme {
        ProfileScreen(
            backIconResource = R.drawable.ic_back,
            profileImageResource = R.drawable.profile_picture,
            editIconResource = R.drawable.ic_door
        )
    }
}