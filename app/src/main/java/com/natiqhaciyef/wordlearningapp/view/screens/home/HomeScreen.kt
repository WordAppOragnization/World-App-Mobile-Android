package com.natiqhaciyef.wordlearningapp.view.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.CarRental
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.natiqhaciyef.wordlearningapp.data.model.GroupModel
import com.natiqhaciyef.wordlearningapp.data.model.WordModel
import com.natiqhaciyef.wordlearningapp.ui.theme.*
import com.natiqhaciyef.wordlearningapp.view.components.GroupCards
import com.natiqhaciyef.wordlearningapp.view.components.MulticoloredText

val testList = mutableListOf<WordModel>(
    WordModel(
        id = 0,
        title = "Table",
        level = "Beginner",
        description = "Something",
        translate = "Masa",
        translateLanguage = "Azerbaijan"
    ),
    WordModel(
        id = 0,
        title = "Pen",
        level = "Beginner",
        description = "Something",
        translate = "Qelem",
        translateLanguage = "Azerbaijan"
    ),
    WordModel(
        id = 0,
        title = "Pencil",
        level = "Beginner",
        description = "Something",
        translate = "Sade qelem",
        translateLanguage = "Azerbaijan"
    ),
    WordModel(
        id = 0,
        title = "Ice",
        level = "Beginner",
        description = "Something",
        translate = "Buz",
        translateLanguage = "Azerbaijan"
    ),
)


val testGroupList = mutableListOf(
    GroupModel(
        id = 0,
        name = "Group 1",
        image = Icons.Outlined.Bed,
        category = "Furniture",
        type = "Idioms",
        wordList = testList,
        level = "B2",
        wordCount = testList.size,
        isFinished = false
    ),
    GroupModel(
        id = 0,
        name = "Group 2",
        image = Icons.Outlined.CarRental,
        category = "Cars",
        type = "Words",
        wordList = testList,
        level = "B2",
        wordCount = testList.size,
        isFinished = false
    )
)


@Composable
fun HomeScreen(
//    navController: NavController
) {
    HomeTopView {
        HomeBodyView(
//            navController
        )
        HomeBottomView()
    }
}

@Preview
@Composable
fun HomeTopView(content: @Composable () -> Unit = { }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppDarkGreenBlue),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        MulticoloredText(selectedText = "Welcome,",
            unSelectedText = " Guess")
        content()
    }
}

//@Preview
@Composable
fun HomeBodyView(
//    navController: NavController
) {
    Spacer(modifier = Modifier.height(150.dp))
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentColor = Color.White,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {

        LazyColumn(
            modifier = Modifier
        ) {
            items(
                items = testGroupList
            ) { group ->
                GroupCards(group) {
//                    navController.navigate(ScreenID.WordsScreen.name)
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun HomeBottomView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.height(22.dp))

        HorizontalPager(pageCount = 3) {

        }
        Spacer(modifier = Modifier.height(75.dp))
    }
}