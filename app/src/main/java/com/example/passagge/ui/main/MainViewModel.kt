package com.example.passagge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passagge.data.api.GamesLibraryModel
import com.example.passagge.data.api.GamesLibraryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GamesLibraryRepository
): ViewModel() {

    private val _gameNames: MutableLiveData<List<GamesLibraryModel>> = MutableLiveData()
    val gameNames: LiveData<List<GamesLibraryModel>> get() = _gameNames

    init {
        viewModelScope.launch {
            _gameNames.postValue(repository.getGameNames().body())
        }
    }
}