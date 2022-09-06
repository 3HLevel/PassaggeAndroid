package com.example.passagge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.passagge.R
import com.example.passagge.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.activityMainBottomNav.setOnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.menu_home -> {
//                    if (savedInstanceState == null) {
//                        supportFragmentManager.beginTransaction()
//                            .add(R.id.activity_main__fragment,
//                                FeedFragment::class.java, null)
//                            .commit()
//                    }
//                    true
//                }
//                R.id.menu_search -> {
//                    true
//                }
//                R.id.menu_likes -> {
//                    true
//                }
//                R.id.menu_profile -> {
//                    true
//                }
//                else -> false
//            }
//        }


    }
}