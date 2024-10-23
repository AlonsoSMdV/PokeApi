package com.example.pokedexapi.data.remote
import retrofit2.http.GET
import retrofit2.http.Path
interface PokeApi {

    @GET("api/v2/pokemon")
    suspend fun read(): String

    @GET("api/v2/pokemon")
    suspend fun readOne(@Path("id") id: Int): String

    @GET("api/v2/pokemon")
    suspend fun readOne(@Path("name") name: String): String
}