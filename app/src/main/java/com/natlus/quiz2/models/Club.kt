package com.natlus.quiz2.models

import com.natlus.quiz2.R

data class Club(
    var name: String = "",
    var imageLogo: Int = R.drawable.ic_launcher_background,
    var playerList: List<String>
)