package com.example.front_end

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_end.ui.theme.Front_EndTheme

@SuppressLint("CustomSplashScreen")
@Composable
fun SplashScreen3(
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(onClick = { onNextClick() }) {
        Text(text = "Next")
    }
    Button(onClick = { onBackClick() }) {
        Text(text = "Back")
    }

    Scaffold(
        topBar = {},
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F5EE))
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, end = 15.dp)
                    .align(Alignment.TopEnd)
            ) {
                Text(
                    text = "Lewati",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000),
                    modifier = Modifier
                        .clickable { onSkipClick() }
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp)
                    .align(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.splash3),
                        contentDescription = null,
                        modifier = Modifier.size(300.dp)
                    )
                }

                Text(
                    text = "Kelola peternakan Anda dengan lebih efisien!",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(horizontal = 40.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Aplikasi ini membantu Anda memantau kondisi kesehatan ternak," +
                            " mengatur jadwal vaksinasi, dan menganalisis data pertumbuhan." +
                            " Hemat waktu dan tenaga Anda!",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(horizontal = 40.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable { onBackClick() }
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.tengah3),
                        contentDescription = null,
                        modifier = Modifier.size(150.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.next),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clickable { onNextClick() }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreen3Preview() {
    Front_EndTheme {
        SplashScreen3(
            onSkipClick = {},
            onNextClick = {},
            onBackClick = {}
        )
    }
}

