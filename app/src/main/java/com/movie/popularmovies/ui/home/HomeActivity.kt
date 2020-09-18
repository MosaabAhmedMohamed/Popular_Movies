package com.movie.popularmovies.ui.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.movie.popularmovies.R
import com.movie.popularmovies.ui.base.BaseActivity
import com.movie.popularmovies.util.extintion.logD
import com.movie.popularmovies.util.extintion.logV
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class HomeActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

}