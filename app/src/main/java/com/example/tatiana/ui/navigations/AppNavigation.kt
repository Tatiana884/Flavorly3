package com.example.tatiana.ui.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tatiana.ui.screens.authentication.forgotpassword.ForgotPasswordScreen
import com.example.tatiana.ui.screens.authentication.login.LoginScreen
import com.example.tatiana.ui.screens.authentication.register.RegisterScreen
import com.example.tatiana.ui.screens.home.HomeScreen
import com.example.tatiana.ui.screens.onboarding.OnboardingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ROUTES.ONBOARDING.name,
    ) {
        composable(ROUTES.ONBOARDING.name) {
            OnboardingScreen {
                navController.navigate(ROUTES.LOGIN.name) {
                    popUpTo(ROUTES.ONBOARDING.name) { inclusive = true }
                }
            }
        }
        composable(ROUTES.LOGIN.name) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(ROUTES.HOME.name) {
                        popUpTo(ROUTES.LOGIN.name) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(ROUTES.REGISTER.name)
                },
                onNavigateToForgotPassword = {
                    navController.navigate(ROUTES.FORGOT_PASSWORD.name)
                }
            )
        }
        composable(ROUTES.REGISTER.name) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(ROUTES.LOGIN.name)
                },
                onNavigateToLogin = {
                    navController.navigate(ROUTES.LOGIN.name)
                }
            )
        }
        composable(ROUTES.FORGOT_PASSWORD.name) {
            ForgotPasswordScreen(
                onResetSent = {
                    navController.navigate(ROUTES.LOGIN.name)
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTES.HOME.name) {
            HomeScreen()
        }
    }
}
