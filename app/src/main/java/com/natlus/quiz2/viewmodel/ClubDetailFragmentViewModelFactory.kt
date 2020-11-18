package com.natlus.quiz2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natlus.quiz2.models.Player

class ClubDetailFragmentViewModelFactory(private val listPlayer: ArrayList<Player>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClubDetailFragmentViewModel::class.java)) {
            return ClubDetailFragmentViewModel(listPlayer = listPlayer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}