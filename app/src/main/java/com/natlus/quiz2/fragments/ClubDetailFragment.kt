package com.natlus.quiz2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.natlus.quiz2.R
import com.natlus.quiz2.databinding.FragmentClubDetailBinding
import com.natlus.quiz2.recyclerview.PlayerAdapter
import com.natlus.quiz2.viewmodel.ClubDetailFragmentViewModel
import com.natlus.quiz2.viewmodel.ClubDetailFragmentViewModelFactory

class ClubDetailFragment : Fragment() {
    private lateinit var binding: FragmentClubDetailBinding
    private lateinit var viewModel: ClubDetailFragmentViewModel
    val args: ClubDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val club = args.club
        Log.e("Club", club.playerList.toString())
        viewModel = ViewModelProvider(
            this,
            ClubDetailFragmentViewModelFactory(listPlayer = club.playerList)
        ).get(ClubDetailFragmentViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_club_detail, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvPlayer()
    }

    private fun setupRvPlayer() {
        val recyclerView = binding.rvPlayer
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = PlayerAdapter()
        recyclerView.adapter = adapter
        viewModel.listPlayerLiveData.observe(viewLifecycleOwner, { value ->
            adapter.playerList = value
        })
    }
}