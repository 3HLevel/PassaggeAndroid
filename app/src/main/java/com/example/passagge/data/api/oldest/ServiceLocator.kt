//package com.example.passagge.data
//
//import com.example.passagge.data.api.GamesLibraryModel
//import com.example.passagge.data.api.NetworkService
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//object ServiceLocator {
//    private lateinit var networkService: NetworkService
//    private var list: List<GamesLibraryModel>? = null
//    private val responseCallback = object: Callback<List<GamesLibraryModel>> {
//        override fun onResponse(
//            call: Call<List<GamesLibraryModel>>,
//            response: Response<List<GamesLibraryModel>>,
//        ) {
//            if (response.isSuccessful) {
//                list = response.body()
//            } else {
//                println(response.errorBody())
//            }
//        }
//
//        override fun onFailure(call: Call<List<GamesLibraryModel>>, t: Throwable) {
//            t.printStackTrace()
//        }
//
//        networkService.createGamesLibraryCall().enqueue(responseCallback)
//    }
//    fun callGamesLibrary() {
//        networkService = NetworkService()
//        networkService.createGamesLibraryCall()
//    }
//}