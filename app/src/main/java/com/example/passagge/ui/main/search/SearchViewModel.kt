package com.example.passagge.ui.main.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passagge.data.api.retrofit.rawg.models.RawgGamesModel
import com.example.passagge.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: SearchRepository
) : ViewModel() {
    private val _categoryList: MutableLiveData<RawgGamesModel> = MutableLiveData()
    val categoryList: LiveData<RawgGamesModel> get() = _categoryList

    init {
        viewModelScope.launch {
            _categoryList.value = repository.getGames().body()
        }
    }

}