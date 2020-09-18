package com.movie.popularmovies.di

import com.movie.popularmovies.di.home.HomeFragmentsModule
import com.movie.popularmovies.di.home.HomeModule
import com.movie.popularmovies.di.home.HomeScope
import com.movie.popularmovies.di.home.HomeViewModelModule
import com.movie.popularmovies.di.splash.SplashScope
import com.movie.popularmovies.ui.home.HomeActivity
import com.movie.popularmovies.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {



    /**
     * Injects [SplashActivity]
     *
     * @return an instance of [SplashActivity]
     */

    @SplashScope
    @ContributesAndroidInjector
    internal abstract fun splashActivity(): SplashActivity

    @HomeScope
    @ContributesAndroidInjector( modules = [HomeModule::class,
        HomeViewModelModule::class,
        HomeFragmentsModule::class])
    internal abstract fun homeActivity(): HomeActivity

}