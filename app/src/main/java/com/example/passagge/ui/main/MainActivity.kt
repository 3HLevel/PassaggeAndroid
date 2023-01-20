package com.example.passagge.ui.main

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.passagge.R
import com.example.passagge.databinding.ActivityMainBinding
import com.example.passagge.ui.main.feed.FeedFragment
import com.example.passagge.ui.main.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        binding.activityMainBottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_home -> {
                    if (savedInstanceState == null) {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.activity_main__fragment,
                                FeedFragment::class.java, null)
                            .commit()
                    }
                    true
                }
                R.id.menu_search -> {
                    true
                }
                R.id.menu_likes -> {
                    true
                }
                R.id.menu_profile -> {
                    if (savedInstanceState == null) {
                        supportFragmentManager.beginTransaction()
                            .add(R.id.activity_main__fragment,
                                ProfileFragment::class.java, null)
                            .commit()
                    }
                    true
                }
                else -> false
            }
        }


    }
}