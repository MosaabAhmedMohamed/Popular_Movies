package com.movie.popularmovies.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.movie.popularmovies.ui.home.dialog.RetryDialog

abstract class BaseFragment constructor(
    @LayoutRes
    private val layoutRes: Int) : Fragment(layoutRes) {


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
        if (retry) RetryDialog.newInstance().show(childFragmentManager, RetryDialog::class.simpleName)
    }

}