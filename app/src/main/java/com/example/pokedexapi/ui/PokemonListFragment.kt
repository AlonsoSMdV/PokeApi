package com.example.pokedexapi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokedexapi.databinding.FragmentPokemonListBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment: Fragment() {
    private lateinit var binding: FragmentPokemonListBinding
    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            val rv = binding.pokemonList
            rv.adapter = PokemonListAdapter()

            viewModel.uiState.collect{
                uiState ->
                when(uiState){
                    PokemonListUiState.Loading -> {}
                    is PokemonListUiState.Success -> {
                        (rv.adapter as PokemonListAdapter).submitList(uiState.pokemonList)
                    }
                    is PokemonListUiState.Error -> {
                        // TODO()
                    }
                }
            }
        }
    }
}
