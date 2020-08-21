package com.movie.popularmovies.di

import android.app.Application
import com.movie.popularmovies.di.home.HomeComponent
import com.movie.popularmovies.di.splash.SplashComponent
import com.movie.popularmovies.ui.base.BaseActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        SubComponentsModule::class
    ]
)
interface AppComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(baseActivity: BaseActivity)

    fun homeComponent(): HomeComponent.Factory

    fun splashComponent(): SplashComponent.Factory


}








