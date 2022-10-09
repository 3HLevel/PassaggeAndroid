package com.example.passagge.data.local.game.post.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PostEntity.TABLE_NAME)
class PostEntity() {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "postId")
    var id: Int? = null

    @ColumnInfo(name = "postComment")
    var comment: String? = null

    @ColumnInfo(name = "postImageUrl")
    var imageUrl: String? = null

    @ColumnInfo(name = "nickname")
    var nickname: String? = null

    @ColumnInfo(name = "postTime")
    var time: String? = null

    constructor(comment: String, imageUrl: String) : this() {
        this.comment = comment
        this.imageUrl = imageUrl
    }

    companion object {
        const val TABLE_NAME = "post_table"
    }
}