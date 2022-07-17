package com.example.passagge.data.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GamesLibraryApi {
    @Headers(
        "X-RapidAPI-Key: 016f3c5bbbmsh0faa81faa29fa2dp1435a6jsn89fb0345793d",
        "X-RapidAPI-Host: cheapshark-game-deals.p.rapidapi.com"
    )
    @GET("/games")
    fun getGamesList(@Query("title") title: String): Call<List<GamesLibraryResponse>>
}