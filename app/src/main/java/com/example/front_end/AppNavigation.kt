package com.example.front_end

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "landing_page"
    ) {
        composable("landing_page") {
            LandingPage()

            // Menambahkan efek delay untuk navigasi ke SplashScreen1
            LaunchedEffect(Unit) {
                delay(2000) // Delay 2 detik
                navController.navigate("splash_screen1") {
                    popUpTo("landing_page") { inclusive = true } // Menghapus LandingPage dari back stack
                }
            }
        }

        composable("splash_screen1") {
            SplashScreen1(
                onSkipClick = { /* Implement Skip if needed */ },
                onNextClick = { navController.navigate("splash_screen2")
                }
            )
        }

        composable("splash_screen2") {
            SplashScreen2(
                onSkipClick = { /* Implement Skip if needed */ },
                onNextClick = { navController.navigate("splash_screen3")
                },
                onBackClick = { navController.popBackStack()
                }
            )
        }

        composable("splash_screen3") {
            SplashScreen3(
                onSkipClick = { /* Implement Skip if needed */ },
                onNextClick = { navController.navigate("splash_screen4") },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("splash_screen4") {
            SplashScreen4(
                onSkipClick = { /* Implement Skip if needed */ },
                onNextClick = { /* Handle next navigation if needed */ },
                onBackClick = { navController.popBackStack()
                }
            )
        }
    }
}
