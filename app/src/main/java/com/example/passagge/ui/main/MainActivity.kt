package com.example.passagge.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
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
import com.example.passagge.ui.main.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

private const val MY_PERMISSIONS_REQUEST = 1234
private val PERMISSIONS = arrayOf<String>(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)

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
                            .replace(R.id.activity_main__fragment,
                                FeedFragment::class.java, null)
                            .commit()
                    }
                    true
                }
                R.id.menu_search -> {
                    if (savedInstanceState == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(
                                R.id.activity_main__fragment,
                                SearchFragment::class.java, null
                            )
                            .commit()
                    }
                    true
                }
                R.id.menu_likes -> {
                    true
                }
                R.id.menu_profile -> {
                    if (savedInstanceState == null) {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.activity_main__fragment,
                                ProfileFragment::class.java, null)
                            .commit()
                    }
                    true
                }
                else -> false
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST && grantResults.isNotEmpty()){
            if (isPermissions()){
                (Objects.requireNonNull(this.getSystemService(Context.ACTIVITY_SERVICE)) as ActivityManager).clearApplicationUserData()
                recreate()
            }
        }
    }

    @SuppressLint("NewApi")
    private fun isPermissions():Boolean{
        PERMISSIONS.forEach {
            if (checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED){
                return true
            }
        }
        return false
    }
}