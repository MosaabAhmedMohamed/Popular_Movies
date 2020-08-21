package com.movie.popularmovies

import android.app.Application
import com.movie.popularmovies.di.AppComponent
import com.movie.popularmovies.di.DaggerAppComponent
import com.movie.popularmovies.di.home.HomeComponent
import com.movie.popularmovies.di.splash.SplashComponent
import timber.log.Timber

class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    private var homeComponent: HomeComponent? = null

    private var splashComponent: SplashComponent? = null


    override fun onCreate() {
        super.onCreate()
        initAppComponent()
        initTimber()
    }

    fun releaseHomeComponent() {
        homeComponent = null
    }

    fun homeComponent(): HomeComponent {
        if (homeComponent == null) {
            homeComponent = appComponent.homeComponent().create()
        }
        return homeComponent as HomeComponent
    }

    fun releaseSplashComponent() {
        splashComponent = null
    }

    fun splashComponent(): SplashComponent {
        if (splashComponent == null) {
            splashComponent = appComponent.splashComponent().create()
        }
        return splashComponent as SplashComponent
    }


    fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            /* if (LeakCanary.isInAnalyzerProcess(this)) {
                 return
             }
             LeakCanary.install(this)*/
        }
    }
}


