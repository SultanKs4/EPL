package com.natlus.quiz2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natlus.quiz2.models.Club

class ClubFragmentViewModel(private var listClub: ArrayList<Club>) : ViewModel() {
    private val listClubMutableLiveData: MutableLiveData<List<Club>> = MutableLiveData(listClub)
    val listClubLiveData: LiveData<List<Club>>
        get() = listClubMutableLiveData
}