package com.example.passagge.ui.main.create

import android.widget.EditText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.local.post.room.dao.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    fun createPost(v: EditText) {
        val post: PostEntity = PostEntity()
        post.description = v.text.toString()
        post.time = System.currentTimeMillis().toString()
        post.nickname = "vymanvar"
        post.imageUrl = "null"
        viewModelScope.launch {
            repository.setPost(post)
        }
    }

}