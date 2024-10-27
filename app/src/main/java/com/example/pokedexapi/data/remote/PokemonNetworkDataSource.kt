package com.example.pokedexapi.data.remote

import com.example.pokedexapi.data.Pokemon
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonNetworkDataSource @Inject constructor(
    private  val pokeApi: PokeApi
): PokemonRemoteDataSource{
    override suspend fun readAll(): Response<PokemonListRaw> {
        return pokeApi.read()
    }

    override suspend fun readOne(id: Int): Response<Pokemon> {
        return pokeApi.readOne(id)
    }
}