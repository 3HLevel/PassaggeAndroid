package com.example.passagge.activity

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.passagge.R

class StartViewModel: ViewModel() {
    fun navigateToLogin(v: View) {
        v.findNavController().navigate(R.id.login_fragment)
    }
}