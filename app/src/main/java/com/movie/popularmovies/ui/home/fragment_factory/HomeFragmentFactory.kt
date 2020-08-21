package com.movie.popularmovies.ui.home.fragment_factory

import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import com.movie.popularmovies.di.home.HomeScope
import com.movie.popularmovies.ui.home.fragment.MovieDetailFragment
import com.movie.popularmovies.ui.home.fragment.MoviesFragment
import javax.inject.Inject

@HomeScope
class HomeFragmentFactory
@Inject
constructor(
    private val viewModelFactory: ViewModelProvider.Factory,
    private val requestOptions: RequestOptions,
    private val requestManager: RequestManager
): FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {

            MoviesFragment::class.java.name -> {
                MoviesFragment(viewModelFactory, requestManager)
            }

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment(viewModelFactory, requestManager)
            }

            else -> {
                MoviesFragment(viewModelFactory, requestManager)
            }
        }

}
