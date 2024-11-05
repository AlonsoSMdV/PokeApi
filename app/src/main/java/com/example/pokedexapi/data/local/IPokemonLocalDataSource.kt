package com.example.pokedexapi.data.local

import com.example.pokedexapi.data.Pokemon
import kotlinx.coroutines.flow.Flow

interface IPokemonLocalDataSource {
    suspend fun insert(pokemon: List<Pokemon>)

    suspend fun readAll(): List<Pokemon>

    fun observeAll(): Flow<List<Pokemon>>
}