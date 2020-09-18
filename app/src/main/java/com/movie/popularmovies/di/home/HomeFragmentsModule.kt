package com.movie.popularmovies.di.home

import com.movie.popularmovies.ui.home.fragment.MovieDetailFragment
import com.movie.popularmovies.ui.home.fragment.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment

}