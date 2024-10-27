package com.example.pokedexapi.data.remote

data class PokemonListRaw(
    val count: Int,
    val prev: String?,
    val next: String?,
    val results: List<PokemonRaw>
)
