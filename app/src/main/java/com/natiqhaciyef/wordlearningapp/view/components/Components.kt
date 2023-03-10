package com.natiqhaciyef.wordlearningapp.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natiqhaciyef.wordlearningapp.data.model.GroupModel
import com.natiqhaciyef.wordlearningapp.data.model.NavItem
import com.natiqhaciyef.wordlearningapp.data.model.WordModel
import com.natiqhaciyef.wordlearningapp.data.util.FontList
import com.natiqhaciyef.wordlearningapp.ui.theme.*

@Composable
fun BottomShadow(
    alpha: Float = 0.1f, height: Dp = 8.dp,
    padding: Dp = 0.dp
) {
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
                        Icon(
                            item.icon,
                            contentDescription = item.title,
                            modifier = Modifier.padding(bottom = 3.dp)
                        )
                        if (selected) {
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .alpha(0.4f)
                                    .background(color = AppDarkOrange)
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

@Composable
fun WordCards(word: WordModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 7.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(15.dp),
        elevation = 2.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = word.title,
                modifier = Modifier
                    .width(130.dp)
                    .padding(horizontal = 12.dp, vertical = 5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(25.dp))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "To"
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = word.translate,
                modifier = Modifier
                    .width(130.dp)
                    .padding(horizontal = 12.dp, vertical = 5.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}


val groupModel = GroupModel(
    id = 0,
    name = "Group 1",
    image = Icons.Default.Bed,
    category = "Furniture",
    type = "Words",
    wordList = mutableListOf(),
    level = "B2",
    wordCount = 10,
    isFinished = false
)

@Preview
@Composable
fun GroupCards(
    group: GroupModel = groupModel,
    onClick: () -> Unit = { }
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 10.dp, vertical = 7.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier,
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${group.name}",
                fontSize = 25.sp,
                color = Color.Black,
                fontFamily = FontList.fontFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AppDarkBlue
                            )
                        ) {
                            append("Level : ${group.level}")
                        }
                    }
                )

                Spacer(modifier = Modifier.width(55.dp))
                Text(
                    text = "${group.wordCount} items to learn",
                    fontSize = 15.sp,
                    color = AppOrange,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(55.dp))
                Text(
                    text = group.type,
                    fontSize = 15.sp,
                    color = AppDarkBlue,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}


@Preview
@Composable
fun MulticoloredText(
    selectedText: String = "",
    unSelectedText: String = ""
) {
    Text(
        modifier = Modifier
            .width(200.dp)
            .padding(start = 40.dp),
        textAlign = TextAlign.Start,
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontList.fontFamily
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        color = AppOrange,
                    )
                ) {
                    append(text = selectedText)
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.White
                    )
                ) {
                    append(text = unSelectedText)
                }
            }
        }
    )
}