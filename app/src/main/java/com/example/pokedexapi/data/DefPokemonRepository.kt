package com.example.pokedexapi.data

import com.example.pokedexapi.data.remote.PokemonListRaw
import com.example.pokedexapi.data.remote.PokemonNetworkDataSource
import com.example.pokedexapi.data.remote.PokemonRemoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefPokemonRepository @Inject constructor(
    private val remoteData: PokemonRemoteDataSource
): PokemonRepository{

    private val _state = MutableStateFlow<List<Pokemon>>(listOf())
    override val setStream: StateFlow<List<Pokemon>>
            get() = _state.asStateFlow()


    override suspend fun readAll(): List<Pokemon> {
        val res = remoteData.readAll()
        val pokes = _state.value.toMutableList()
        if (res.isSuccessful){
            val pkmnList = res.body()!!.results
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
        else Pokemon(0,"")
    }

    private fun idUrl(url: String): Int?{
        return url.trimEnd('/').substringAfterLast('/').toIntOrNull()
    }
}