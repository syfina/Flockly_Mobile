package com.example.flockly

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flockly.ui.theme.FlocklyTheme

@Composable
fun LoginScreen(){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login Image", modifier = Modifier.size(200.dp)
        )
        Box(
            modifier = Modifier.fillMaxWidth().padding(start = 60.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Masuk", fontSize = 20.sp, fontWeight = FontWeight.Bold,)
            Spacer(modifier = Modifier.height(4.dp))


        }
        Box(
            modifier = Modifier.fillMaxWidth().padding(start = 60.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(text = "Silahkan masuk untuk melanjutkan")
        }
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label = {
            Text(text = "Masukkan Email")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {
            Text(text = "Masukkan Kata Sandi")
        }, visualTransformation = PasswordVisualTransformation())
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier.fillMaxWidth().padding(end = 55.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
        Text(text = "Lupa Kata Sandi?", textAlign = TextAlign.End, modifier = Modifier.clickable {

        })
            }
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                Log.i("Credential", "Email: $email, Password: $password")
            }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp),
            colors = ButtonDefaults.buttonColors( containerColor = Color(0xFF5F4A43) )

        ) {
            Text(text = "Masuk")
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,

        ){
            Text(text = "Belum punya akun?")
            Text(text = "Daftar", modifier = Modifier.clickable {

            },fontWeight = FontWeight.Bold )
            Spacer(modifier = Modifier.height(32.dp))
        }

        Image(
            painter = painterResource(id = R.drawable.flockly_logo1),
            contentDescription = "Logo Image", modifier = Modifier.size(100.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FlocklyTheme {
        LoginScreen()
    }
}