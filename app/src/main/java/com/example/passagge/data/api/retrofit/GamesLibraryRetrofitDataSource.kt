package com.example.passagge.data.api.retrofit

import com.example.passagge.data.api.GamesLibraryModel
import retrofit2.Response
import javax.inject.Inject

class GamesLibraryRetrofitDataSource constructor(
    private val apiService: GamesLibraryApiService
): GamesLibraryExternalDataSource {

    override suspend fun loadGameNames(): Response<List<GamesLibraryModel>> =
        apiService.getGamesList("batman")

}