package com.example.passagge.presentation.entry.reg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.passagge.databinding.FragmentRegBinding

class RegFragment : Fragment() {

    private val viewModel: RegViewModel by viewModels()
    private lateinit var binding: FragmentRegBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegBinding.inflate(layoutInflater)
        binding.fragmentRegFirstButton.setOnClickListener() {
            /*что-то*/
        }
        return binding.root
    }

}