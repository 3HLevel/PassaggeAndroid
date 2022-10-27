package com.example.passagge.ui.entry.reg

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.passagge.R
import com.example.passagge.data.firebase.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegViewModel: ViewModel() {

    private val passaggeAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val passaggeDatabase: DatabaseReference = FirebaseDatabase.getInstance().getReference("user")

    private lateinit var user: UserModel

    fun createUser(
        nickname: String,
        email: String,
        password: String,
        v: View
    ): Boolean {
        passaggeAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                v.findNavController().navigate(R.id.mainActivity)
            }
            .addOnCanceledListener {

            }

        user = UserModel(
            nickname,
            email,
            password
        )
        passaggeDatabase.push().setValue(user)
        return (true)
    }
}