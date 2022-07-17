package com.example.passagge.di

import com.example.passagge.data.api.GamesLibraryResponse
import com.example.passagge.data.api.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ServiceLocator {
    private lateinit var networkService: NetworkService
    private var list: List<GamesLibraryResponse>? = null
    private val responseCallback = object: Callback<List<GamesLibraryResponse>> {
        override fun onResponse(
            call: Call<List<GamesLibraryResponse>>,
            response: Response<List<GamesLibraryResponse>>,
        ) {
            if (response.isSuccessful) {
                list = response.body()
            } else {
                println(response.errorBody())
            }
        }

        override fun onFailure(call: Call<List<GamesLibraryResponse>>, t: Throwable) {
            t.printStackTrace()
        }
    }
    fun callGamesLibrary() {
        networkService = NetworkService()
        networkService.createGamesLibraryCall()
    }
}