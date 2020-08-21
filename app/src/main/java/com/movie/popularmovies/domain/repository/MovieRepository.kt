package com.movie.popularmovies.domain.repository

import androidx.paging.Pager
import com.movie.popularmovies.data.remote.model.MovieDetailModel
import com.movie.popularmovies.data.remote.model.Results
import io.reactivex.Single

interface MovieRepository {

    fun getMovie(id: Int): Single<MovieDetailModel>

    fun getMoviesPager(): Pager<Int, Results>
}