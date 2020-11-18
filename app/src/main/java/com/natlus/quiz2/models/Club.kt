package com.natlus.quiz2.models

import android.os.Parcelable
import com.natlus.quiz2.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(
    var name: String = "",
    var imageLogo: Int = R.drawable.ic_launcher_background,
    var playerList: ArrayList<Player>
) : Parcelable