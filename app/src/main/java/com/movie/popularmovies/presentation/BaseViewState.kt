package com.movie.popularmovies.presentation

import com.movie.popularmovies.util.NetworkState

open class BaseViewState<R> {
    var networkState: NetworkState? = null
    var response: R? = null

}