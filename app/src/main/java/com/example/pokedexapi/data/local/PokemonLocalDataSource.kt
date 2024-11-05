package com.example.pokedexapi.data.local

import com.example.pokedexapi.data.Pokemon
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor(
    private val pokemonDao: PokemonDao
): IPokemonLocalDataSource {
    override suspend fun insert(pokemon: List<Pokemon>) {
        pokemonDao.create(pokemon.toLocal())
    }

    override suspend fun readAll(): List<Pokemon> {
        return pokemonDao.readAll().toExternal()
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        return  pokemonDao.observeAll().map { localPokemon -> localPokemon.toExternal() }
    }
}