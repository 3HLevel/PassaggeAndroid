package com.example.passagge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passagge.data.api.CheapSharkModel
import com.example.passagge.data.api.PostRepository
import com.example.passagge.data.local.game.post.room.dao.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: PostRepository
): ViewModel() {

    private val _gameNames: MutableLiveData<List<PostEntity>> = MutableLiveData()
    val gameNames: LiveData<List<PostEntity>> get() = _gameNames

    init {
        viewModelScope.launch {
            _gameNames.postValue(repository.getPostList())
        }
    }
}