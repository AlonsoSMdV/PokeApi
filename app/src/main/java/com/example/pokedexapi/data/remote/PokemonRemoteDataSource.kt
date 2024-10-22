package com.example.pokedexapi.data.remote

interface PokemonRemoteDataSource {

    suspend fun readAll():String
    suspend fun readOne(id:Int):String
}