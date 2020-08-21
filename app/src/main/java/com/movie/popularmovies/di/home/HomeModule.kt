package com.movie.popularmovies.di.home

import com.movie.popularmovies.data.remote.client.HomeApi
import com.movie.popularmovies.data.repository.MovieRepositoryImpl
import com.movie.popularmovies.domain.repository.MovieRepository
import com.movie.popularmovies.domain.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object HomeModule {

    @JvmStatic
    @HomeScope
    @Provides
    fun provideHomeApi(retrofit: Retrofit.Builder): HomeApi {
        return retrofit
            .build()
            .create(HomeApi::class.java)
    }

    @JvmStatic
    @HomeScope
    @Provides
    fun provideMovieRepository(api: HomeApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @JvmStatic
    @HomeScope
    @Provides
    fun provideMovieUseCase(repository: MovieRepository): MovieUseCase {
        return MovieUseCase(repository)
    }

}
