package com.example.passagge.ui.main.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.passagge.data.provider.models.MediaStoreImage

class ProfileViewModel : ViewModel() {

    private val _images = MutableLiveData<List<MediaStoreImage>>()
    val images: LiveData<List<MediaStoreImage>> get() = _images

}