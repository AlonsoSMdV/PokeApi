package com.example.pokedexapi.data

interface PokemonRepository {
    suspend fun readAll():String
    suspend fun readOne(id:Int):String
}