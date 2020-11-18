package com.natlus.quiz2.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natlus.quiz2.databinding.ItemClubBinding
import com.natlus.quiz2.models.Club

class ClubAdapter(clubList: List<Club>? = arrayListOf()) :
    RecyclerView.Adapter<ClubAdapter.ClubViewHolder>() {

    var clubList = clubList
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ClubViewHolder(private val binding: ItemClubBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(club: Club?) {
            binding.club = club
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemClubBinding = ItemClubBinding.inflate(layoutInflater, parent, false)
        return ClubViewHolder(itemClubBinding)
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bind(clubList?.get(position))
    }

    override fun getItemCount(): Int {
        return clubList?.size ?: 0
    }
}