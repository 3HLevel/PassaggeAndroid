package com.example.passagge.data.local.post.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = PostEntity.TABLE_NAME)
class PostEntity(): Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "postId")
    var id: Int? = null

    @ColumnInfo(name = "postComment")
    var description: String? = null

    @ColumnInfo(name = "postImageUrl")
    var imageUrl: String? = null

    @ColumnInfo(name = "nickname")
    var nickname: String? = null

    @ColumnInfo(name = "postTime")
    var time: String? = null

    constructor(description: String, imageUrl: String, nickname: String, time: String) : this() {
        this.description = description
        this.imageUrl = imageUrl
        this.nickname = nickname
        this.time = time
    }

    companion object {
        const val TABLE_NAME = "post_table"
    }
}