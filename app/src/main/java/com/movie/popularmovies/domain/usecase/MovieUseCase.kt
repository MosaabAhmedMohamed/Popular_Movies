package com.movie.popularmovies.domain.usecase

import androidx.paging.Pager
import com.movie.popularmovies.data.remote.model.MovieDetailModel
import com.movie.popularmovies.data.remote.model.Results
import com.movie.popularmovies.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieUseCase  @Inject constructor(private val repository: MovieRepository) {



    fun getMovie(id: Int): Single<MovieDetailModel> {
        return repository.getMovie(id)
    }

    fun getMoviesPager(): Pager<Int, Results> {
        return repository.getMoviesPager()
    }
}