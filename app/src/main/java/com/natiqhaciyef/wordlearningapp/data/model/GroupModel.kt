package com.natiqhaciyef.wordlearningapp.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class GroupModel(
    var id : Int,
    var name : String,
    var image: ImageVector,
    var category: String,
    var wordList: MutableList<WordModel>,
)
