package com.example.passagge.data.api.retrofit.rawg

import com.example.passagge.data.api.retrofit.rawg.models.RawgGamesModel
import retrofit2.Response

interface RawgExternalDataSource {

    suspend fun loadGames(): Response<RawgGamesModel>
}