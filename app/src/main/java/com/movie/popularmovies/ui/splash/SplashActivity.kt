package com.movie.popularmovies.ui.splash

import android.content.Intent
import android.os.Bundle
import com.movie.popularmovies.BaseApplication
import com.movie.popularmovies.R
import com.movie.popularmovies.ui.home.HomeActivity
import com.movie.popularmovies.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SplashActivity : BaseActivity() , HasAndroidInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        goToHome()
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }


}