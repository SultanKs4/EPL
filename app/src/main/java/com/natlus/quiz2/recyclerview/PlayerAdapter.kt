package com.natlus.quiz2.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natlus.quiz2.databinding.ItemPlayerBinding
import com.natlus.quiz2.models.Player

class PlayerAdapter() :
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
    var playerList: List<Player>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player?) {
            binding.player = player
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPlayerBinding = ItemPlayerBinding.inflate(layoutInflater, parent, false)
        return PlayerViewHolder(itemPlayerBinding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(playerList?.get(position))
    }

    override fun getItemCount(): Int {
        return playerList?.size ?: 0
    }
}