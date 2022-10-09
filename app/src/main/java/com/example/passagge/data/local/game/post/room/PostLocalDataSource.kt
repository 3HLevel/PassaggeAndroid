package com.example.passagge.data.local.game.post.room

import com.example.passagge.data.local.game.post.room.dao.PostEntity

interface PostLocalDataSource {

    suspend fun loadPostList(): List<PostEntity>

    suspend fun savePostList(list: List<PostEntity>)

    suspend fun savePost(post: PostEntity): PostEntity

}