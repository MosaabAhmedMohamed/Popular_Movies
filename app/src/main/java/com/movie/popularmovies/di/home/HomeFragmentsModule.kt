package com.movie.popularmovies.di.home

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.movie.popularmovies.ui.home.fragment_factory.HomeFragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object HomeFragmentsModule {

    @JvmStatic
    @HomeScope
    @Provides
    @Named("HomeFragmentFactory")
    fun provideHomeFragmentFactory(
        viewModelFactory: ViewModelProvider.Factory,
        requestOptions: RequestOptions,
        requestManager: RequestManager
    ): FragmentFactory {
        return HomeFragmentFactory(
            viewModelFactory,
            requestOptions,
            requestManager
        )
    }
}