package com.movie.popularmovies.ui.home

import android.os.Bundle
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.movie.popularmovies.BaseApplication
import com.movie.popularmovies.R
import com.movie.popularmovies.ui.base.BaseActivity
import com.movie.popularmovies.ui.home.fragment_factory.HomeNavHostFragment
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class HomeActivity  : BaseActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    @Named("HomeFragmentFactory")
    lateinit var homeFragmentFactory: FragmentFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Timber.tag(this::class.java.simpleName)
        onRestoreInstanceState()
    }

    private fun onRestoreInstanceState() {
        val host = supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment)
        host?.let {
            // do nothing
        } ?: createNavHost()
    }

    private fun createNavHost() {
        val navHost = HomeNavHostFragment.create(
            R.navigation.home_nav_graph
        )
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.home_nav_host_fragment,
                navHost,
                getString(R.string.HomeNavHost)
            )
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }


    override fun inject() {
        (application as BaseApplication).homeComponent()
            .inject(this)
    }


}