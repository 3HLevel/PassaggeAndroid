package com.example.passagge.ui.main

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.passagge.data.api.GamesLibraryResponse
import com.example.passagge.data.api.NetworkService
import com.example.passagge.R
import com.example.passagge.databinding.ActivityMainBinding
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val networkService: NetworkService = NetworkService()
    private var list: List<GamesLibraryResponse>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val responseCallback: Callback<List<GamesLibraryResponse>> = object: Callback<List<GamesLibraryResponse>> {
            override fun onResponse(
                call: Call<List<GamesLibraryResponse>>,
                response: Response<List<GamesLibraryResponse>>,
            ) {
                if (response.isSuccessful) {
                    list = response.body()
                    val textView: TextView = findViewById(R.id.textView)
                    textView.text = list?.get(1)?.external
                } else {
                    println(response.errorBody())
                }
            }

            override fun onFailure(call: Call<List<GamesLibraryResponse>>, t: Throwable) {
                t.printStackTrace()
            }
        }

        networkService.createGamesLibraryCall().enqueue(responseCallback)
    }

    suspend fun main() = coroutineScope {
        launch {

        }
    }
}