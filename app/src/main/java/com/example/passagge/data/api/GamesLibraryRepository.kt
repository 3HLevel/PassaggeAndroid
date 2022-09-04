package com.example.passagge.data.api

import com.example.passagge.data.api.retrofit.GamesLibraryExternalDataSource
import retrofit2.Response
import javax.inject.Inject

class GamesLibraryRepository constructor(
    private val gamesLibraryExternalDataSource: GamesLibraryExternalDataSource
) {
    suspend fun getGameNames(): Response<List<GamesLibraryModel>> {
        return gamesLibraryExternalDataSource.loadGameNames()
    }
}