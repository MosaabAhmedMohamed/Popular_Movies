package com.movie.popularmovies.di.splash

import com.movie.popularmovies.ui.splash.SplashActivity
import dagger.Subcomponent

@SplashScope
@Subcomponent
interface SplashComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun inject(splashActivity: SplashActivity)
}