package com.example.passagge.data.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passagge.data.local.post.room.dao.PostDao
import com.example.passagge.data.local.post.room.dao.PostEntity

@Database(entities = [
    PostEntity::class
], version = 1, exportSchema = true)
abstract class PostRoomDataBase: RoomDatabase() {
    abstract fun postDao(): PostDao
}