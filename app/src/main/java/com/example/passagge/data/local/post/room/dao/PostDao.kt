package com.example.passagge.data.local.post.room.dao

import androidx.room.*

@Dao
interface PostDao {
    @Query("SELECT * FROM ${PostEntity.TABLE_NAME}")
    suspend fun loadAllPosts(): List<PostEntity>

    @Insert(entity = PostEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePost(postEntity: PostEntity)

    @Insert
    @JvmSuppressWildcards
    suspend fun saveAllPosts(post: List<PostEntity>)

    @Delete(entity = PostEntity::class)
    suspend fun deletePost(postEntity: PostEntity)
}