package com.natlus.quiz2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.natlus.quiz2.R
import com.natlus.quiz2.databinding.FragmentClubBinding
import com.natlus.quiz2.models.Club
import com.natlus.quiz2.models.Player
import com.natlus.quiz2.recyclerview.ClubAdapter
import com.natlus.quiz2.recyclerview.OnItemClubListener
import com.natlus.quiz2.viewmodel.ClubFragmentViewModel
import com.natlus.quiz2.viewmodel.ClubFragmentViewModelFactory

class ClubFragment : Fragment() {
    private lateinit var binding: FragmentClubBinding
    private lateinit var viewModel: ClubFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val clubList: ArrayList<Club> = club()
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

    private fun club(): ArrayList<Club> {
        val club: ArrayList<Club> = arrayListOf()
        val clubArray: Array<String> = resources.getStringArray(R.array.club)
        val playerClubList: ArrayList<Array<String>> = arrayListOf(
            resources.getStringArray(R.array.ArsenalPlayer),
            resources.getStringArray(R.array.AstonPlayer),
            resources.getStringArray(R.array.ChelseaPlayer),
            resources.getStringArray(R.array.EvertonPlayer),
            resources.getStringArray(R.array.FullhamPlayer),
        )
        val logoClubList = arrayListOf(
            R.drawable.arsenal,
            R.drawable.aston_villa,
            R.drawable.chelsea,
            R.drawable.everton,
            R.drawable.fullham,
        )
        clubArray.forEachIndexed { index, name ->
            val playerList: ArrayList<Player> = arrayListOf()
            for (player in playerClubList[index]) {
                playerList.add(
                    Player(name = player)
                )
            }
            club.add(
                Club(name = name, imageLogo = logoClubList[index], playerList = playerList)
            )
        }
        return club
    }

    private fun setupRvClub() {
        val recyclerView = binding.rvClub
        val gridLayoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = gridLayoutManager
        val adapter = ClubAdapter(itemClubListener = object : OnItemClubListener {
            override fun onClubClicked(club: Club) {
                viewModel.onClubClicked(club)
            }
        })
        recyclerView.adapter = adapter
        viewModel.listClubLiveData.observe(
            viewLifecycleOwner,
            { value -> adapter.clubList = value })
        viewModel.navigateToDetailLiveData.observe(viewLifecycleOwner, { value ->
            if (value != null) {
                val action =
                    ClubFragmentDirections.actionClubFragmentToClubDetailFragment(club = value)
                findNavController().navigate(action)
                viewModel.onMovieDetailNavigated()
            }
        })
    }
}