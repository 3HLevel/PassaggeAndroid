package com.example.passagge.ui.main.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.passagge.R
import com.example.passagge.databinding.FragmentCreatePostBinding
import com.example.passagge.ui.main.feed.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreatePostFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModels()
    private lateinit var binding: FragmentCreatePostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreatePostBinding.inflate(layoutInflater)
        binding.fragmentCreatePostCancel.setOnClickListener {
            binding.root.findNavController().popBackStack()
        }
        binding.fragmentCreatePostConfirm.setOnClickListener {
            viewModel.createPost(binding.fragmentCreatePostEditText)
        }
        return binding.root
    }


}