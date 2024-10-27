package com.example.pokedexapi.di

import com.example.pokedexapi.data.DefPokemonRepository
import com.example.pokedexapi.data.PokemonRepository
import com.example.pokedexapi.data.remote.PokeApi
import com.example.pokedexapi.data.remote.PokemonNetworkDataSource
import com.example.pokedexapi.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val POKEAPI_URL = "https://pokeapi.co/"

@Module
@InstallIn(SingletonComponent::class)
class NetWorkModule{
    @Provides
    @Singleton
    fun providePokeApiService(): PokeApi{
        val service = Retrofit.Builder()
            .baseUrl(POKEAPI_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApi::class.java)
        return service
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Binds
    abstract fun bindPokemonRepository(repository: DefPokemonRepository): PokemonRepository

    @Binds
    abstract fun bindPokemonRemote(remote: PokemonNetworkDataSource): PokemonRemoteDataSource
}