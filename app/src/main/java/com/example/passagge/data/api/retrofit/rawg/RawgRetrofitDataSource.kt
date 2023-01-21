package com.example.passagge.data.api.retrofit.rawg

import com.example.passagge.data.api.retrofit.rawg.models.RawgGamesModel
import retrofit2.Response

class RawgRetrofitDataSource(
    private val apiService: RawgApiService
): RawgExternalDataSource {

    override suspend fun loadGames(): Response<RawgGamesModel> {
        return apiService.getGames("d674cb778791452894b73fd5ef5f1510", "2019-09-01,2023-01-18")
    }
}