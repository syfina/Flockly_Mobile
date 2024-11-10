package com.example.agrisphere

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.agrisphere.ui.theme.AgrisphereTheme


@Composable
fun VerifScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(painter = painterResource(id = R.drawable.flockly),
            contentDescription = "Logo Flockly",
            modifier = Modifier.size(200.dp))

        Text(text = "Verifikasi Alamat Email",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "Masukan kode verifikasi dari alamat email anda, " +
                "silahkan periksa email anda.")

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun OtpTextField(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 4,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(Unit) {
            if (otpText.length > otpCount) {
                throw IllegalArgumentException("Kode OTP tidak boleh lebih dari $otpCount karakter")
            }
        }

        BasicTextField(
            modifier = modifier,
            value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
            onValueChange = {
                if (it.text.length <= otpCount) {
                    onOtpTextChange.invoke(it.text, it.text.length == otpCount)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            decorationBox = {
                Row(horizontalArrangement = Arrangement.Center) {
                    repeat(otpCount) { index ->
                        CharView(
                            index = index,
                            text = otpText
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Sisa waktu (60 Detik)",
            textAlign = TextAlign.End)

        Button(
            onClick = {},
            modifier = Modifier
                .clickable {}
                .width(200.dp)
                .background(color = colorResource(id = R.color.color1)) // Sets the background color
                .padding(2.dp)
        ) {
            Text(text = "Verifikasi")
        }

        Row {
            Text(text = "Belum Menerima Kode Verifikasi?")
            Text(text = "Kirim Ulang Kode", color = colorResource(id = R.color.color1))
        }
    }
}

@Composable
private fun CharView(
    index: Int,
    text: String
) {

    val char = when {
        index == text.length -> "0"
        index > text.length -> ""
        else -> text[index].toString()
    }

    Text(
        modifier = Modifier
            .width(40.dp)
            .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .padding(2.dp),
        text = char,
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center
    )
}


//Preview Section
@Preview(showBackground = true)
@Composable
fun VerifScreenPreview() {
    AgrisphereTheme {
        VerifScreen()
}
