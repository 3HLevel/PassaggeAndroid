package com.example.passagge.ui.main.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passagge.databinding.FragmentFeedBinding
import com.example.passagge.ui.main.adapters.FeedAdapter

class FeedFragment : Fragment() {
    private val viewModel: FeedViewModel by viewModels()
    lateinit var binding: FragmentFeedBinding
    val feedAdapter = FeedAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(layoutInflater)
        binding.fragmentFeedRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//        binding.fragmentFeedRecycler.adapter = feedAdapter
        binding.fragmentCreatePostCancel.setOnClickListener {
            viewModel.navToCreatePost(binding.root)
        }
        return binding.root
    }

}