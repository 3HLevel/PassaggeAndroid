package com.example.passagge.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.passagge.R

class StartFragment : Fragment() {
    lateinit var firstButton: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstButton = view.findViewById<Button>(R.id.fragment_start__first_button)
        firstButton.setOnClickListener {
            findNavController().navigate(R.id.login_fragment)
        }
    }
}