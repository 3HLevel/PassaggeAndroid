package com.example.passagge.ui.main.feed

import android.Manifest
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.View
import android.widget.EditText
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.passagge.R
import com.example.passagge.data.repository.PostRepository
import com.example.passagge.data.local.post.room.dao.PostEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
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

    fun createPost(
        v: EditText,
        context: Context
    ) {
        val post: PostEntity = PostEntity()
        post.description = v.text.toString()
        post.time = System.currentTimeMillis().toString()
        post.nickname = "vymanvar"

        val uri: Uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val cursor: Cursor?
        val column_index_data: Int
        val column_index_folder_name: Int
        val listOfAllImages = ArrayList<String>()
        var absolutePathOfImage: String? = null

        val projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)

        cursor = context.contentResolver.query(uri, projection, null,
            null, null);

        column_index_data = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        column_index_folder_name = cursor
            .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data)
            listOfAllImages.add(absolutePathOfImage)
        }

        if (listOfAllImages.reversed().isNotEmpty()) {
            post.imageUrl = listOfAllImages.reversed().first()
        } else {
            post.imageUrl = null
        }

        viewModelScope.launch {
            repository.setPost(post)
            v.findNavController().popBackStack()
        }
    }
}