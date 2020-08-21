package com.movie.popularmovies.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieModel(
    @Expose
    @SerializedName("page")
    var page: Int,
    @Expose
    @SerializedName("total_results")
    var total_results: Int,
    @Expose
    @SerializedName("total_pages")
    var total_pages: Int,
    @SerializedName("results")
    @Expose
    var results: List<Results>) {

}

data class Results(
    @Expose
    @SerializedName("popularity")
    val popularity: Double,
    @Expose
    @SerializedName("vote_count")
    var vote_count: Int,
    @Expose
    @SerializedName("video")
    var video: Boolean,
    @Expose
    @SerializedName("poster_path")
    val poster_path: String,
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("adult")
    var adult: Boolean,
    @Expose
    @SerializedName("backdrop_path")
    val backdrop_path: String,
    @Expose
    @SerializedName("original_language")
    val original_language: String,
    @Expose
    @SerializedName("original_title")
    val original_title: String,
    @Expose
    @SerializedName("genre_ids")
    var genre_ids: List<Int>,
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("vote_average")
    var vote_average: Float,
    @Expose
    @SerializedName("overview")
    val overview: String,
    @Expose
    @SerializedName("release_date")
    val release_date: String
)