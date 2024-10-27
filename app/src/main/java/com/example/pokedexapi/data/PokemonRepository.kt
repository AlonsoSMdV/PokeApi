package com.example.pokedexapi.data

import com.example.pokedexapi.data.remote.PokemonListRaw
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

interface PokemonRepository {
    val setStream: StateFlow<List<Pokemon>>
    suspend fun readAll(): List<Pokemon>
    suspend fun readOne(id:Int): Pokemon
}