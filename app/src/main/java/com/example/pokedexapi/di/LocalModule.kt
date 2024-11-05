package com.example.pokedexapi.di

import android.content.Context
import androidx.room.Room
import com.example.pokedexapi.data.DefPokemonRepository
import com.example.pokedexapi.data.PokemonRepository
import com.example.pokedexapi.data.local.AppDataBase
import com.example.pokedexapi.data.local.IPokemonLocalDataSource
import com.example.pokedexapi.data.local.PokemonDao
import com.example.pokedexapi.data.local.PokemonLocalDataSource
import com.example.pokedexapi.data.remote.PokeApi
import com.example.pokedexapi.data.remote.PokemonNetworkDataSource
import com.example.pokedexapi.data.remote.PokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalModule{
    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase{
        return Room.databaseBuilder(context,
            AppDataBase::class.java,
            "app-db"
        ).build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(dataBase: AppDataBase): PokemonDao {
        return dataBase.pokemonDao()
    }
}

