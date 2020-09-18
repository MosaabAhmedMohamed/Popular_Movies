package com.movie.popularmovies.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.movie.popularmovies.R
import com.movie.popularmovies.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject


class HomeActivity  : BaseActivity() , HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Timber.tag(this::class.java.simpleName)

    }


}