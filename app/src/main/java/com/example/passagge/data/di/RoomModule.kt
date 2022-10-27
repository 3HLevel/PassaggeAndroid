package com.example.passagge.data.di

import android.content.Context
import androidx.room.Room
import com.example.passagge.data.local.base.PostRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            PostRoomDataBase::class.java,
            "passagge_base"
        ).build()
}