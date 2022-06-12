package com.example.passagge.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.passagge.R
import com.example.passagge.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {
    private lateinit var viewModel: FeedViewModel
    lateinit var binding: FragmentFeedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(layoutInflater)
        binding.fragmentFeedRecycler
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

}