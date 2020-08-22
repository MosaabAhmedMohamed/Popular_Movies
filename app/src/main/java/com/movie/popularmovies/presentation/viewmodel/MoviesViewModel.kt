package com.movie.popularmovies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.liveData
import com.movie.popularmovies.data.remote.model.MovieDetailModel
import com.movie.popularmovies.data.remote.model.Results
import com.movie.popularmovies.di.home.HomeScope
import com.movie.popularmovies.domain.usecase.MovieUseCase
import com.movie.popularmovies.presentation.BaseViewState
import com.movie.popularmovies.util.NetworkState
import com.movie.popularmovies.util.rx.AppSchedulerProvider
import io.reactivex.functions.Consumer
import javax.inject.Inject

@HomeScope
class MoviesViewModel
@Inject constructor(private var useCase: MovieUseCase) :
    BaseViewModel(
        AppSchedulerProvider.instance.io()
        , AppSchedulerProvider.instance.ui()
    ) {

    val movieVS: MutableLiveData<BaseViewState<MovieDetailModel>> = MutableLiveData()

    private var movies: Pager<Int, Results>? = null

    fun movie(id: Int) {
        val viewState: BaseViewState<MovieDetailModel> = BaseViewState()
        viewState.networkState = NetworkState.LOADED
        execute(
            Consumer {
                viewState.networkState = NetworkState.LOADING
                movieVS.postValue(viewState)
            },
            Consumer {
                viewState.networkState = NetworkState.LOADED
                viewState.response = it
                movieVS.postValue(viewState)
            },
            Consumer { throwable ->
                viewState.networkState = getFailedNetworkState(throwable)
                movieVS.postValue(viewState)
            },
            useCase.getMovie(id).toFlowable()
        )
    }

    fun moviesList(): LiveData<PagingData<Results>> {
        if (movies == null) movies = useCase.getMoviesPager()

        return movies!!.liveData
    }

    override fun onCleared() {
        super.onCleared()
        movies = null
    }

}

