package com.natlus.quiz2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natlus.quiz2.models.Player

class ClubDetailFragmentViewModel(private var listPlayer: ArrayList<Player>) : ViewModel() {
    private val _mutableListPlayer: MutableLiveData<List<Player>> = MutableLiveData(listPlayer)
    val listPlayerLiveData: LiveData<List<Player>>
        get() = _mutableListPlayer
}