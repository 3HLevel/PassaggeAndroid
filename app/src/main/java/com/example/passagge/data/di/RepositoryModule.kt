package com.example.passagge.data.di

import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.api.retrofit.CheapSharkApiService
import com.example.passagge.data.api.retrofit.CheapSharkExternalDataSource
import com.example.passagge.data.api.retrofit.CheapSharkRetrofitDataSource
import com.example.passagge.data.local.base.PostRoomDataBase
import com.example.passagge.data.local.game.post.room.PostLocalDataSource
import com.example.passagge.data.local.game.post.room.RoomPostLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideGamesLibraryRepository(
        /*cheapSharkExternalDataSource: CheapSharkExternalDataSource,*/
        postLocalDataSource: PostLocalDataSource
    ): PostRepository =
        PostRepository(postLocalDataSource)

    @Singleton
    @Provides
    fun provideLocalDataSource(
        postRoomDataBase: PostRoomDataBase
    ): PostLocalDataSource =
        RoomPostLocalDataSource(postRoomDataBase.postDao())

    @Singleton
    @Provides
    fun provideExternalDataSource(
        apiService: CheapSharkApiService
    ): CheapSharkExternalDataSource =
        CheapSharkRetrofitDataSource(apiService)
}