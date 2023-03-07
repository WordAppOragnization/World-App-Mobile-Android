package com.natiqhaciyef.wordlearningapp.view.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natiqhaciyef.wordlearningapp.data.model.GroupModel
import com.natiqhaciyef.wordlearningapp.data.model.WordModel
import com.natiqhaciyef.wordlearningapp.ui.theme.AppOrange
import com.natiqhaciyef.wordlearningapp.view.components.GroupCards
import com.natiqhaciyef.wordlearningapp.view.components.WordCards

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


val testGroupList = mutableListOf<GroupModel>(
    GroupModel(
        id = 0,
        image = Icons.Outlined.Bed,
        category = "Furniture",
        wordList = testList
    )
)


@Composable
fun HomeScreen() {
    HomeTopView {
        HomeBodyView()
        HomeBottomView()
    }
}

@Preview
@Composable
fun HomeTopView(content: @Composable () -> Unit = { }) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppOrange),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        content()
    }
}

@Preview
@Composable
fun HomeBodyView() {
    Spacer(modifier = Modifier.height(280.dp))
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentColor = Color.White,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {

//        LazyColumn(
//            modifier = Modifier
//        ) {
//            items(
//                items = testList
//            ) { group ->
//                GroupCards() {
//                    // navigation to details screen
//                }
//            }
//        }
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