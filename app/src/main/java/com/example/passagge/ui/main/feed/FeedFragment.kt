package com.example.passagge.ui.main.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passagge.data.api.PostRepository
import com.example.passagge.databinding.FragmentFeedBinding
import com.example.passagge.ui.main.adapters.FeedAdapter
import com.example.passagge.ui.main.adapters.FeedTouchHelperCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FeedFragment : Fragment() {
    private val viewModel: FeedViewModel by viewModels()
    lateinit var binding: FragmentFeedBinding
    @Inject lateinit var repository: PostRepository

    private lateinit var feedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(layoutInflater)

        binding.fragmentFeedRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        viewModel.postList.observe(viewLifecycleOwner) {
            feedAdapter = FeedAdapter(it, requireContext(), repository)
            binding.fragmentFeedRecycler.adapter = feedAdapter

            val callback: ItemTouchHelper.Callback = FeedTouchHelperCallback(feedAdapter)
            val touchHelper: ItemTouchHelper = ItemTouchHelper(callback)
            touchHelper.attachToRecyclerView(binding.fragmentFeedRecycler)
        }

        binding.fragmentCreatePostCancel.setOnClickListener {
            viewModel.navToCreatePost(binding.root)
        }

        return binding.root
    }

}
