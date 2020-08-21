package com.movie.popularmovies.ui.splash

import android.content.Intent
import android.os.Bundle
import com.movie.popularmovies.BaseApplication
import com.movie.popularmovies.R
import com.movie.popularmovies.ui.home.HomeActivity
import com.movie.popularmovies.ui.base.BaseActivity

class SplashActivity : BaseActivity() {


    override fun inject() {
        (application as BaseApplication)
            .splashComponent()
            .inject(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        goToHome()
    }

    private fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
        (application as BaseApplication).releaseSplashComponent()
    }
}