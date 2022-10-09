package com.example.passagge.ui.main.create

import android.view.View
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.local.game.post.room.dao.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postList: MutableLiveData<List<PostEntity>> = MutableLiveData()
    val postList: LiveData<List<PostEntity>> get() = _postList

    init {
        viewModelScope.launch {
            _postList.postValue(repository.getPostList());
        }
    }

    fun createPost(v: EditText) {
        val post: PostEntity = PostEntity()
        post.comment = v.text.toString()
//            post.time =
//            post.nickname = from firebase
        viewModelScope.launch {
            repository.setPost(post)
        }
    }

}