package com.example.pokedexapi.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkDataSource @Inject constructor(
    private  val pokeApi: PokeApi
): PokemonRemoteDataSource{
    override suspend fun readAll(): String {
        val pokes = pokeApi.read()
        return pokes
    }

    override suspend fun readOne(id: Int): String {
        return pokeApi.readOne(id)
    }
}