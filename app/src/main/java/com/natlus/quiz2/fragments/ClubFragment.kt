package com.natlus.quiz2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.natlus.quiz2.R
import com.natlus.quiz2.databinding.FragmentClubBinding
import com.natlus.quiz2.models.Club
import com.natlus.quiz2.recyclerview.ClubAdapter
import com.natlus.quiz2.viewmodel.ClubFragmentViewModel
import com.natlus.quiz2.viewmodel.ClubFragmentViewModelFactory

class ClubFragment : Fragment() {
    private lateinit var binding: FragmentClubBinding
    private lateinit var viewModel: ClubFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val clubList: ArrayList<Club> = arrayListOf(
            Club(
                name = "Arsenal",
                imageLogo = R.drawable.ic_launcher_background,
                playerList = arrayListOf(
                    "a", "b", "c", "d", "e", "f", "g"
                )
            ),
            Club(
                name = "Aston Villa",
                imageLogo = R.drawable.ic_launcher_background,
                playerList = arrayListOf(
                    "a", "b", "c", "d", "e", "f", "g"
                )
            ),
            Club(
                name = "Chealsea",
                imageLogo = R.drawable.ic_launcher_background,
                playerList = arrayListOf(
                    "a", "b", "c", "d", "e", "f", "g"
                )
            ),
            Club(
                name = "Everton",
                imageLogo = R.drawable.ic_launcher_background,
                playerList = arrayListOf(
                    "a", "b", "c", "d", "e", "f", "g"
                )
            ),
            Club(
                name = "Fullham",
                imageLogo = R.drawable.ic_launcher_background,
                playerList = arrayListOf(
                    "a", "b", "c", "d", "e", "f", "g"
                )
            ),
        )
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_club, container, false)
        viewModel = ViewModelProvider(this, ClubFragmentViewModelFactory(listClub = clubList)).get(
            ClubFragmentViewModel::class.java
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvClub()
    }

    private fun setupRvClub() {
        val recyclerView = binding.rvClub
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager
        val adapter = ClubAdapter()
        recyclerView.adapter = adapter
        viewModel.listClubLiveData.observe(
            viewLifecycleOwner,
            { value -> adapter.clubList = value })
    }
}