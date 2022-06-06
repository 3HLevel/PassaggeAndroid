package com.example.passagge.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.passagge.R
import com.example.passagge.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private val v: StartViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        binding.fragmentStartFirstButton.setOnClickListener() {
            v.navigateToLogin(binding.root)
        }
        return binding.root
    }

}