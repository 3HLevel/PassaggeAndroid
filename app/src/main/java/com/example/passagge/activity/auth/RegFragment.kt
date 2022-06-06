package com.example.passagge.activity.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.passagge.R
import com.example.passagge.databinding.FragmentRegBinding
import com.example.passagge.databinding.FragmentStartBinding

class RegFragment : Fragment() {
    /*модель из фрагмента*/
    private val v: RegViewModel by viewModels()
    private lateinit var binding: FragmentRegBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegBinding.inflate(layoutInflater)
        binding.fragmentRegFirstButton.setOnClickListener() {
            /*что-то*/
        }
        return inflater.inflate(R.layout.fragment_reg, container, false)
    }

}