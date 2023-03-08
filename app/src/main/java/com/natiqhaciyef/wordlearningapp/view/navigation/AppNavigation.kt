package com.natiqhaciyef.wordlearningapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.natiqhaciyef.wordlearningapp.view.screens.home.MainScreen
import com.natiqhaciyef.wordlearningapp.view.screens.home.WordsScreen
import com.natiqhaciyef.wordlearningapp.view.screens.registration.LoginScreen
import com.natiqhaciyef.wordlearningapp.view.screens.registration.RegisterScreen
import com.natiqhaciyef.wordlearningapp.view.screens.registration.ResetPasswordScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenID.HomeScreen.name){
        composable(ScreenID.RegisterScreen.name){
            RegisterScreen(navController)
        }

        composable(ScreenID.LoginScreen.name){
            LoginScreen(navController)
        }

        composable(ScreenID.ResetPasswordScreen.name){
            ResetPasswordScreen()
        }

        composable(ScreenID.HomeScreen.name){
            MainScreen(navController)
        }

        // Home Navigation
        composable(ScreenID.WordsScreen.name){
            WordsScreen()
        }
    }
}