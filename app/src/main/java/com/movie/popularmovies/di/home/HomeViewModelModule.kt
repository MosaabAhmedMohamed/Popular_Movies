package com.movie.popularmovies.di.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movie.popularmovies.presentation.viewmodel.HomeViewModelFactory
import com.movie.popularmovies.presentation.viewmodel.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: HomeViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @HomeViewModelKey(MoviesViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: MoviesViewModel): ViewModel

}