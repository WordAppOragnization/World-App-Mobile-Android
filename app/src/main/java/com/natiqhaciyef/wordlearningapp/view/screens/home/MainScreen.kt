package com.natiqhaciyef.wordlearningapp.view.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.natiqhaciyef.wordlearningapp.view.components.NavigationBarAnimation


@Preview
@Composable
fun MainScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { NavigationBarAnimation() }
    ) {
        it.calculateBottomPadding()
    }
}


