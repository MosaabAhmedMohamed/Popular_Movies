package com.movie.popularmovies.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieModel(
    var page: Int,
    var total_results: Int,
    var total_pages: Int,
    var results: List<Results>) {

}

data class Results(
    val popularity: Double,
    var vote_count: Int,
    var video: Boolean,
    val poster_path: String,
    var id: Int,
    var adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    var genre_ids: List<Int>,
    val title: String,
    var vote_average: Float,
    val overview: String,
    val release_date: String
)