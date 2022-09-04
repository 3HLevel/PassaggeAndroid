package com.example.passagge.data.api

data class GamesLibraryModel (
    var gameID: String,
    var steamAppID: String,
    var cheapest: String,
    var cheapestDealID: String,
    var external: String,
    var internalName: String,
    var thumb: String
)