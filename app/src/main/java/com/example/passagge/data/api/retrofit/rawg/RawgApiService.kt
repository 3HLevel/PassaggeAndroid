package com.example.passagge.data.api.retrofit.rawg

import com.example.passagge.data.api.retrofit.rawg.models.RawgGamesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApiService {
    @GET("games")
    suspend fun getGames(@Query("key") key: String, @Query("dates") dates: String): Response<RawgGamesModel>
}