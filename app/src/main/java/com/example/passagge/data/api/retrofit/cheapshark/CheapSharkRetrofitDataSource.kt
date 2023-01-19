package com.example.passagge.data.api.retrofit

import com.example.passagge.data.api.CheapSharkModel
import retrofit2.Response

class CheapSharkRetrofitDataSource constructor(
    private val apiService: CheapSharkApiService
): CheapSharkExternalDataSource {

    override suspend fun loadGamesInfo(): Response<List<CheapSharkModel>> =
        apiService.getGameInfoList("batman")

}