package com.example.pokedexapi.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexapi.data.Pokemon
import com.example.pokedexapi.databinding.PokemonItemBinding

class PokemonListAdapter: ListAdapter<Pokemon, PokemonListAdapter.PokemonViewHolder>(PokemonComparer) {
    inner class PokemonViewHolder(
        private val binding: PokemonItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(pkmn: Pokemon){
            binding.pokeId.text = pkmn.id.toString()
            binding.pokeName.text = pkmn.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = PokemonItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return  PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pkmn = getItem(position)
        holder.bind(pkmn)
    }

    object PokemonComparer: DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.id == newItem.id
        }
    }
}