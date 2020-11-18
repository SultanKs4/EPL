package com.natlus.quiz2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natlus.quiz2.models.Club

class ClubFragmentViewModel(private var listClub: ArrayList<Club>) : ViewModel() {
    private val listClubMutableLiveData: MutableLiveData<List<Club>> = MutableLiveData(listClub)
    private val _navigateToDetail = MutableLiveData<Club?>()
    val listClubLiveData: LiveData<List<Club>>
        get() = listClubMutableLiveData
    val navigateToDetailLiveData: LiveData<Club?>
        get() = _navigateToDetail

    fun onClubClicked(club: Club) {
        _navigateToDetail.value = club
    }

    fun onMovieDetailNavigated() {
        _navigateToDetail.value = null
    }
}