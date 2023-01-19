package com.example.passagge.data.api.retrofit

import com.example.passagge.data.api.CheapSharkModel
import retrofit2.Response

interface CheapSharkExternalDataSource {

    suspend fun loadGamesInfo(): Response<List<CheapSharkModel>>
}