package com.movie.popularmovies.data.remote.client

import com.movie.popularmovies.data.remote.model.MovieDetailModel
import com.movie.popularmovies.data.remote.model.MovieModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HomeApi {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String?,
        @Query("page") pageNumber: Int
    ): Single<MovieModel>

    @GET("movie/{movie_id}")
    fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String?
    ): Single<MovieDetailModel>

}