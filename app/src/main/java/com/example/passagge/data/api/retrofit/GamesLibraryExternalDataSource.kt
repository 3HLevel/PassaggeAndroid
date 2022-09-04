package com.example.passagge.data.api.retrofit

import com.example.passagge.data.api.GamesLibraryModel
import retrofit2.Response

interface GamesLibraryExternalDataSource {

    suspend fun loadGameNames(): Response<List<GamesLibraryModel>>
}