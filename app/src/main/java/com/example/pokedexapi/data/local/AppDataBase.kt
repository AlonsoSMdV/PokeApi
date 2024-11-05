package com.example.pokedexapi.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [
    PokemonEntity::class
],
    version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}