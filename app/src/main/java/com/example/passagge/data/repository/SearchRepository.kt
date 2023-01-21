package com.example.passagge.data.repository

import com.example.passagge.data.api.retrofit.rawg.RawgExternalDataSource
import com.example.passagge.data.api.retrofit.rawg.models.RawgGamesModel
import retrofit2.Response

class SearchRepository (
    private val rawgExternalDataSource: RawgExternalDataSource
) {
    suspend fun getGames(): Response<RawgGamesModel> {
        return rawgExternalDataSource.loadGames()
    }
}