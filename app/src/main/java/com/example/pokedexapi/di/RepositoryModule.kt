package com.example.pokedexapi.di

import com.example.pokedexapi.data.DefPokemonRepository
import com.example.pokedexapi.data.PokemonRepository
import com.example.pokedexapi.data.local.IPokemonLocalDataSource
import com.example.pokedexapi.data.local.PokemonLocalDataSource
import com.example.pokedexapi.data.remote.PokemonNetworkDataSource
import com.example.pokedexapi.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule{
    @Singleton
    @Binds
    abstract fun bindPokemonRepository(repository: DefPokemonRepository): PokemonRepository

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(localDataSource: PokemonLocalDataSource): IPokemonLocalDataSource

    @Singleton
    @Binds
    abstract fun bindPokemonRemote(remote: PokemonNetworkDataSource): PokemonRemoteDataSource
}