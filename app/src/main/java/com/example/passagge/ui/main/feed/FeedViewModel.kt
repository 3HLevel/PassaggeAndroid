package com.example.passagge.ui.main.feed

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.passagge.R

class FeedViewModel : ViewModel() {
    fun navToCreatePost(v: View) {
        v.findNavController().navigate(R.id.createPostFragment)
    }
}