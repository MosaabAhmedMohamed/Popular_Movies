package com.movie.popularmovies.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.movie.popularmovies.presentation.BaseViewState
import com.movie.popularmovies.ui.home.dialog.RetryDialog
import com.movie.popularmovies.util.ViewStatus
import timber.log.Timber

abstract class BaseFragment constructor(
    @LayoutRes
    private val layoutRes: Int
) : Fragment(layoutRes) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    protected abstract fun init()
    protected abstract fun onViewClicked()

    open fun showLoading(visibility: Boolean) {
        activity?.let {
            if (visibility) (activity as BaseActivity).showLoading()
            else (activity as BaseActivity).hideLoading()
        }
    }

    open fun showRetryDialog(retry: Boolean) {
        if (retry) RetryDialog.newInstance()
            .show(childFragmentManager, RetryDialog::class.simpleName)
    }

    protected fun <T> renderViewState(viewState: BaseViewState<T>?) {
        if (viewState != null) {
            when (viewState.networkState?.viewStatus) {
                ViewStatus.RUNNING -> {
                    showLoading(true)
                }
                ViewStatus.SUCCESS -> {
                    showLoading(false)
                    viewState.response?.let { it -> renderData(it) }!!
                }
                ViewStatus.FAILED -> {
                    showLoading(false)
                    //makeToast(viewState.getNetworkState().getMessage())*/
                }
                ViewStatus.UNAUTHORIZED -> {
                    showLoading(false)
                    //goToLogin()
                }
            }
        }

    }

    protected open fun <T> renderData(model: T) {

    }

}