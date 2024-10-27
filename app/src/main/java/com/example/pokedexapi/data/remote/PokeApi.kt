package com.example.pokedexapi.data.remote
import com.example.pokedexapi.data.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
interface PokeApi {

    @GET("api/v2/pokemon")
    suspend fun read(): Response<PokemonListRaw>

    @GET("api/v2/pokemon")
    suspend fun readOne(@Path("id") id: Int): Response<Pokemon>
}