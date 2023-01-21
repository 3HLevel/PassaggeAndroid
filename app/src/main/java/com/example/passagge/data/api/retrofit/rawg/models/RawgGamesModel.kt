package com.example.passagge.data.api.retrofit.rawg.models

data class RawgGamesModel (
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<ResultModel>,
    var user_platforms: Boolean
)

data class ResultModel (
    var slug: String,
    var name: String,
    var playtime: Int,
    var platforms: List<PlatformModel>,
    var stores: List<StoreModel>,
    var released: String,
    var tba: Boolean,
    var background_image: String,
    var rating: Double,
    var rating_top: Double,
    var ratings: List<RatingModel>,
    var ratings_count: Int,
    var reviews_text_count: Int,
    var added: Int,
    var added_by_status: AddedByStatusModel,
    var metacritic: Int,
    var suggestions_count: Int,
    var updated: String,
    var id: Int,
    var score: String,
    var clip: String,
    var tags: List<TagModel>,
    var esrb_rating: EsrbRatingModel,
    var user_game: String,
    var reviews_count: Int,
    var saturated_color: String,
    var dominant_color: String,
    var short_screenshots: List<ShortScreenshotsModel>,
    var parent_platforms: List<ParentPlatformModel>,
    var genres: List<GenreModel>
)

data class ParentPlatformModel (
    var platformModel: Platform
)

data class PlatformModel (
    var platformModel: Platform
)

data class Platform (
    var id: Int,
    var name: String,
    var slug: String
)

data class StoreModel (
    var id: Int,
    var name: String,
    var slug: String,
)

data class RatingModel (
    var id: Int,
    var title: String,
    var count: Int,
    var percent: Double
)

data class AddedByStatusModel (
    var yet: Int,
    var owned: Int,
    var beaten: Int,
    var toplay: Int,
    var dropped: Int,
    var playing: Int
)

data class TagModel (
    var id: Int,
    var name: String,
    var slug: String,
    var language: String,
    var games_count: Int,
    var image_background: String
)

data class EsrbRatingModel (
    var id: Int,
    var name: String,
    var slug: String,
    var name_en: String,
    var name_ru: String
)

data class ShortScreenshotsModel (
    var id: Int,
    var image: String
)

data class GenreModel (
    var id: Int,
    var name: String,
    var slug: String
)