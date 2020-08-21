package com.movie.popularmovies.di.home

import com.movie.popularmovies.ui.home.HomeActivity
import dagger.Subcomponent

@HomeScope
@Subcomponent(
    modules = [HomeModule::class,
        HomeViewModelModule::class,
        HomeFragmentsModule::class]
)
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    fun inject(homeActivity: HomeActivity)
}