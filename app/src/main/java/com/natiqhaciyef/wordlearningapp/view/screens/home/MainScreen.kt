package com.natiqhaciyef.wordlearningapp.view.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natiqhaciyef.wordlearningapp.view.components.NavigationBarAnimation


@Preview
@Composable
fun MainScreen(){
    val selectedIndex = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { NavigationBarAnimation(selectedIndex) }
    ) {
        it.calculateBottomPadding()

        when(selectedIndex.value){
            0 -> { HomeScreen() }
            1 -> { NotificationScreen() }
            2 -> { UserProfileScreen() }
            else -> HomeScreen()
        }
    }
}


