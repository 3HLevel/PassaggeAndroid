package com.example.passagge.data.di

import com.example.passagge.data.api.GamesLibraryRepository
import com.example.passagge.data.api.retrofit.GamesLibraryApiService
import com.example.passagge.data.api.retrofit.GamesLibraryExternalDataSource
import com.example.passagge.data.api.retrofit.GamesLibraryRetrofitDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideGamesLibraryRepository(
        gamesLibraryExternalDataSource: GamesLibraryExternalDataSource
    ): GamesLibraryRepository =
        GamesLibraryRepository(gamesLibraryExternalDataSource)

    @Provides
    fun provideGamesLibraryExternalDataSource(
        apiService: GamesLibraryApiService
    ): GamesLibraryExternalDataSource =
        GamesLibraryRetrofitDataSource(apiService)
}