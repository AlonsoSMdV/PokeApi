package com.example.pokedexapi.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Insert
    suspend fun create(pokemon: PokemonEntity)

    @Insert
    suspend fun create(pokemon: List<PokemonEntity>)

    @Delete
    suspend fun delete(pokemon: PokemonEntity)

    @Upsert
    suspend fun update(pokemon: PokemonEntity)

    @Query("SELECT * FROM pokemon WHERE id = :id")
    suspend fun readById(id: String): PokemonEntity

    @Query("SELECT * FROM pokemon")
    suspend fun readAll(): List<PokemonEntity>

    @Query("SELECT * FROM pokemon")
    fun observeAll(): Flow<List<PokemonEntity>>
}