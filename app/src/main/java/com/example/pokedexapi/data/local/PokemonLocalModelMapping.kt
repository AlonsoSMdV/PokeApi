package com.example.pokedexapi.data.local

import com.example.pokedexapi.data.Pokemon


fun Pokemon.toLocal() = PokemonEntity(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
    )


fun List<Pokemon>.toLocal(): List<PokemonEntity>{
    return  this.map { p -> p.toLocal() }
}

fun PokemonEntity.toExternal()= Pokemon(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
    )


fun List<PokemonEntity>.toExternal(): List<Pokemon>{
   return map { pokemonEntity ->  pokemonEntity.toExternal() }}
