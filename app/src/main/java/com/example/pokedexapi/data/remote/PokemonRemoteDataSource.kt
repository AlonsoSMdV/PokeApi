package com.example.pokedexapi.data.remote

import com.example.pokedexapi.data.Pokemon
import retrofit2.Response

interface PokemonRemoteDataSource {

    suspend fun readAll():Response<PokemonListRaw>
    suspend fun readOne(id:Int): Response<Pokemon>
}