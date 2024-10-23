package com.example.pokedexapi.data.remote

import com.example.pokedexapi.data.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRemoteDataSource {

    suspend fun readAll():List<Pokemon>
    fun observeAll(): Flow<List<Pokemon>>
    suspend fun readOne(id:Int):Pokemon
    suspend fun readOne(name:String):Pokemon
}