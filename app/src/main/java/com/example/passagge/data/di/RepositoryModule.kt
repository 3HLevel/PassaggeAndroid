package com.example.passagge.data.di

import com.example.passagge.data.repository.PostRepository
import com.example.passagge.data.repository.SearchRepository
import com.example.passagge.data.api.retrofit.CheapSharkApiService
import com.example.passagge.data.api.retrofit.CheapSharkExternalDataSource
import com.example.passagge.data.api.retrofit.CheapSharkRetrofitDataSource
import com.example.passagge.data.api.retrofit.rawg.RawgApiService
import com.example.passagge.data.api.retrofit.rawg.RawgExternalDataSource
import com.example.passagge.data.api.retrofit.rawg.RawgRetrofitDataSource
import com.example.passagge.data.local.base.PostRoomDataBase
import com.example.passagge.data.local.post.room.PostLocalDataSource
import com.example.passagge.data.local.post.room.RoomPostLocalDataSource
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
    fun providePostRepository(
        /*cheapSharkExternalDataSource: CheapSharkExternalDataSource,*/
        postLocalDataSource: PostLocalDataSource
    ): PostRepository =
        PostRepository(postLocalDataSource)

    @Singleton
    @Provides
    fun provideSearchRepository(
        rawgExternalDataSource: RawgExternalDataSource
    ): SearchRepository =
        SearchRepository(rawgExternalDataSource)

    @Singleton
    @Provides
    fun provideLocalDataSource(
        postRoomDataBase: PostRoomDataBase
    ): PostLocalDataSource =
        RoomPostLocalDataSource(postRoomDataBase.postDao())

    @Singleton
    @Provides
    fun provideCheapSharkExternalDataSource(
        apiService: CheapSharkApiService
    ): CheapSharkExternalDataSource =
        CheapSharkRetrofitDataSource(apiService)

    @Singleton
    @Provides
    fun provideRawgExternalDataSource(
        apiService: RawgApiService
    ): RawgExternalDataSource =
        RawgRetrofitDataSource(apiService)
}