package com.natiqhaciyef.wordlearningapp.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.natiqhaciyef.wordlearningapp.view.screens.registration.LoginScreen
import com.natiqhaciyef.wordlearningapp.view.screens.registration.RegisterScreen
import com.natiqhaciyef.wordlearningapp.view.screens.registration.ResetPasswordScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenID.RegisterScreen.name){
        composable(ScreenID.RegisterScreen.name){
            RegisterScreen()
        }

        composable(ScreenID.LoginScreen.name){
            LoginScreen()
        }

        composable(ScreenID.ResetPasswordScreen.name){
            ResetPasswordScreen()
        }
    }

}