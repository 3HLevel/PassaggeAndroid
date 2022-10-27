package com.example.passagge.ui.entry.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.passagge.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.fragmentLoginSecondButton.setOnClickListener {
            viewModel.navToReg(binding.root)
        }
        binding.fragmentLoginFirstButton.setOnClickListener {
            viewModel.signInUser(
                binding.fragmentLoginEmail.text.toString(),
                binding.fragmentLoginPassword.text.toString(),
                binding.root
            )
        }
        return binding.root
    }

}