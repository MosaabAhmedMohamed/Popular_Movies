package com.movie.popularmovies.di

import com.movie.popularmovies.di.home.HomeComponent
import com.movie.popularmovies.di.splash.SplashComponent
import dagger.Module

@Module(
    subcomponents = [
        SplashComponent::class,
        HomeComponent::class
    ]
)
class SubComponentsModule