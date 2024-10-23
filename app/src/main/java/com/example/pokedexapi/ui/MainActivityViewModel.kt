package com.example.pokedexapi.ui

import androidx.lifecycle.ViewModel
import com.example.pokedexapi.data.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repo: PokemonRepository
): ViewModel(){
    suspend fun read(): String{
        return repo.readAll()
    }
}