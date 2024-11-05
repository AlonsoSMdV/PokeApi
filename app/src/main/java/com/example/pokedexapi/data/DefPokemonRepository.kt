package com.example.pokedexapi.data

import com.example.pokedexapi.data.local.IPokemonLocalDataSource
import com.example.pokedexapi.data.local.PokemonLocalDataSource
import com.example.pokedexapi.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefPokemonRepository @Inject constructor(
    private val remoteData: PokemonRemoteDataSource,
    private val localData: IPokemonLocalDataSource
): PokemonRepository{

    private val _state = MutableStateFlow<List<Pokemon>>(listOf())
    override val setStream: StateFlow<List<Pokemon>>
            get() = _state.asStateFlow()


    override suspend fun readAll(): List<Pokemon> {
        val res = remoteData.readAll()
        val pokes = _state.value.toMutableList()
        if (res.isSuccessful){
            val pkmnList = res.body()?.results ?: emptyList()
            pkmnList.forEach { pokeR ->
                pokes.add(readOne(idUrl(pokeR.url)!!))
                _state.emit(pokes.toList())
            }
        }
        else _state.value = pokes
        return pokes
    }

    override suspend fun readOne(id: Int): Pokemon {
        val res = remoteData.readOne(id)
        return if (res.isSuccessful)res.body()!!
        else Pokemon("0","", 0.0, 0.0)
    }

    private fun idUrl(url: String): Int?{
        return url.trimEnd('/').substringAfterLast('/').toIntOrNull()
    }

    override fun observeAll(): Flow<List<Pokemon>> {
        refreshLocal()
        return  localData.observeAll()
    }

    private fun refreshLocal(){
        runBlocking{
            val pokemonRemote = remoteData.readAll()
        }
    }
}