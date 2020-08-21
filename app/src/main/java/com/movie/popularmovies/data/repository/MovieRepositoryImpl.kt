package com.movie.popularmovies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.movie.popularmovies.data.remote.client.HomeApi
import com.movie.popularmovies.data.remote.model.MovieDetailModel
import com.movie.popularmovies.data.remote.model.Results
import com.movie.popularmovies.data.repository.datasource.MoviesDataSource
import com.movie.popularmovies.domain.repository.MovieRepository
import com.movie.popularmovies.util.Constants.Companion.API_KEY
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl
@Inject
constructor(
    private val api: HomeApi
) : MovieRepository {


    override fun getMovie(id: Int): Single<MovieDetailModel> {
        return api.getMovieDetail(id, API_KEY)
    }

    override fun getMoviesPager(): Pager<Int, Results> {
        return Pager(
            PagingConfig( /* pageSize = */15, enablePlaceholders =  false),
            pagingSourceFactory = { MoviesDataSource(api) })
    }
}