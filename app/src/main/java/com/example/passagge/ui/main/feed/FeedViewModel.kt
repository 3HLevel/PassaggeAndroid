package com.example.passagge.ui.main.feed

import android.view.View
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.passagge.R
import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.local.post.room.dao.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.trySendBlocking
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postList: MutableLiveData<List<PostEntity>> = MutableLiveData()
    val postList: LiveData<List<PostEntity>> get() = _postList

    init {
        viewModelScope.launch {
            _postList.postValue(repository.getPostList())
        }
    }

    fun refreshData() {
        viewModelScope.launch {
            _postList.postValue(repository.getPostList())
        }
    }

    fun navToCreatePost(v: View) {
        v.findNavController().navigate(R.id.createPostFragment)
    }

    fun createPost(v: EditText) {
        val post: PostEntity = PostEntity()
        post.description = v.text.toString()
        post.time = System.currentTimeMillis().toString()
        post.nickname = "vymanvar"
        post.imageUrl = "null"

        viewModelScope.launch {
            repository.setPost(post)
            v.findNavController().popBackStack()
        }
    }
}