package com.example.passagge.presentation.auth

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.passagge.R

class LoginViewModel: ViewModel() {
    fun navToReg(v: View) {
        v.findNavController().navigate(R.id.reg_fragment)
    }

    fun navToMain(v: View) {
        v.findNavController().navigate(R.id.mainActivity)
    }
}