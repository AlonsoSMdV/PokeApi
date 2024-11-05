package com.example.pokedexapi.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val height: Double,
    val weight: Double
)