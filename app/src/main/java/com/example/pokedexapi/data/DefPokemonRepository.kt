package com.example.pokedexapi.data

import com.example.pokedexapi.data.remote.PokemonRemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefPokemonRepository @Inject constructor(
    private val remoteData: PokemonRemoteDataSource
): PokemonRepository{
    override suspend fun readAll(): String {
        val pokes = remoteData.readAll()
        return pokes
    }

    override suspend fun readOne(id: Int): String {
        return remoteData.readOne(id)
    }
}