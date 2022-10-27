package com.example.passagge.ui.main.feed

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.passagge.R
import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.local.post.room.dao.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _postList: MutableLiveData<List<PostEntity>> = MutableLiveData()
    val postList: LiveData<List<PostEntity>> get() = _postList

    init {
        viewModelScope.launch {
            _postList.postValue(repository.getPostList());
        }
    }

    fun navToCreatePost(v: View) {
        v.findNavController().navigate(R.id.createPostFragment)
    }
}