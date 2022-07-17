package com.example.passagge.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    private val baseURL: String = "https://cheapshark-game-deals.p.rapidapi.com"
    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    private fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor())
            .build()
    }

    private fun getRetrofit(): Retrofit {
        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(httpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun createGamesLibraryCall(): Call<List<GamesLibraryResponse>> {
        val retrofit = getRetrofit()
        val gamesLibraryApi = retrofit.create(GamesLibraryApi::class.java)
        return gamesLibraryApi.getGamesList("batman")
    }
}