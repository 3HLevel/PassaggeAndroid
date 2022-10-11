package com.example.passagge.data.local.post.room

import com.example.passagge.data.local.post.room.dao.PostDao
import com.example.passagge.data.local.post.room.dao.PostEntity

class RoomPostLocalDataSource(private val postDao: PostDao): PostLocalDataSource {
    override suspend fun loadPostList(): List<PostEntity> {
        return postDao.loadAllPosts()
    }

    override suspend fun savePostList(list: List<PostEntity>) {
        return postDao.saveAllPosts(list)
    }

    override suspend fun savePost(post: PostEntity) {
        return postDao.savePost(post)
    }
}