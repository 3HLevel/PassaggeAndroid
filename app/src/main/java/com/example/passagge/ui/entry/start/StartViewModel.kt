package com.example.passagge.ui.entry.start

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.passagge.R

class StartViewModel: ViewModel() {
    fun navToLogin(v: View) {
        v.findNavController().navigate(R.id.login_fragment)
    }
}