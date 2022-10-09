package com.example.passagge.data.api

import com.example.passagge.data.local.game.post.room.PostLocalDataSource
import com.example.passagge.data.local.game.post.room.dao.PostDao
import com.example.passagge.data.local.game.post.room.dao.PostEntity

class PostRepository constructor(
    /*private val cheapSharkExternalDataSource: CheapSharkExternalDataSource,*/
    private val postLocalDataSource: PostLocalDataSource
) {
    /*suspend fun getGameNames(): Response<List<GamesLibraryModel>> {
        return gamesLibraryExternalDataSource.loadGameNames()
    }
    */

    suspend fun getPostList(): List<PostEntity> {
        return postLocalDataSource.loadPostList()
    }

    suspend fun setPost(post: PostEntity): PostEntity {
        return postLocalDataSource.savePost(post)
    }
}