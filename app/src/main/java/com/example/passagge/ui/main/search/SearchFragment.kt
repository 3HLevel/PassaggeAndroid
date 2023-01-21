package com.example.passagge.ui.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passagge.R
import com.example.passagge.data.repository.SearchRepository
import com.example.passagge.databinding.FragmentSearchBinding
import com.example.passagge.ui.main.adapters.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val viewModel: SearchViewModel by viewModels()
    lateinit var binding: FragmentSearchBinding
//    @Inject lateinit var repository: SearchRepository

    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchAdapter = SearchAdapter(requireContext())
        binding = FragmentSearchBinding.inflate(layoutInflater)

        binding.fragmentSearchRecyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        binding.fragmentSearchRecyclerView.adapter = searchAdapter

        viewModel.categoryList.observe(viewLifecycleOwner) {
            searchAdapter.updateData(it.results)
        }

        return binding.root
    }

}