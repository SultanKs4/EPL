package com.natlus.quiz2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natlus.quiz2.models.Club

class ClubFragmentViewModelFactory(private var listClub: ArrayList<Club>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClubFragmentViewModel::class.java)) {
            return ClubFragmentViewModel(listClub = listClub) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}