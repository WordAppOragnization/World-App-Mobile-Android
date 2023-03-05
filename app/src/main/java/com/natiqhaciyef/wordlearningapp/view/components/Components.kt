package com.natiqhaciyef.wordlearningapp.view.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.model.content.CircleShape
import com.natiqhaciyef.wordlearningapp.data.model.NavItem
import com.natiqhaciyef.wordlearningapp.ui.theme.AppDarkTeal
import com.natiqhaciyef.wordlearningapp.ui.theme.AppLightTeal
import com.natiqhaciyef.wordlearningapp.ui.theme.AppTeal

@Composable
fun BottomShadow(alpha: Float = 0.1f, height: Dp = 8.dp,
                 padding: Dp = 0.dp) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = padding)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Black.copy(alpha = alpha),
                        Color.Transparent,
                    )
                )
            )
    )
}

@Composable
fun BottomShadow(modifier: Modifier) {
    Box(
        modifier = modifier
    )
}

@Composable
fun NavigationBar() {
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp
    ) {
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text(text = "Home") },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
            label = { Text(text = "Favorites") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text(text = "Profile") },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
            label = { Text(text = "Settings") },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun NavigationBarAnimation(selectedTabIndex: MutableState<Int>) {
    val navItems = listOf(
        NavItem(Icons.Filled.Home, "Home"),
        NavItem(Icons.Filled.Notifications, "Notifications"),
        NavItem(Icons.Filled.Person, "Profile"),
    )

    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 8.dp,
    ) {
        navItems.forEachIndexed { index, item ->
            val selected = index == selectedTabIndex.value
            BottomNavigationItem(
                icon = {
                    Box(contentAlignment = Alignment.BottomCenter) {
                        Icon(item.icon, contentDescription = item.title, modifier = Modifier.padding(bottom = 3.dp))
                        if (selected) {
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .alpha(0.4f)
                                    .background(color = AppDarkTeal)
                            )
                        }
                    }
                },
                label = { Text(item.title) },
                selected = selected,
                onClick = {
                    if (!selected) {
                        selectedTabIndex.value = index
                    }
                },
                alwaysShowLabel = false
            )
        }
    }
}


