package com.example.passagge.ui.entry.login

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.passagge.R
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {

    private val passaggeAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun navToReg(v: View) {
        v.findNavController().navigate(R.id.reg_fragment)
    }

    fun signInUser(
        email: String,
        password: String,
        v: View
    ): Boolean {
        passaggeAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                v.findNavController().navigate(R.id.mainActivity)
            }
            .addOnCanceledListener {

            }
        return (true)
    }
}