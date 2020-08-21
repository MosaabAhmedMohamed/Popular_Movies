package com.movie.popularmovies.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.movie.popularmovies.BaseApplication
import com.movie.popularmovies.ui.custom.LoadingProgressDialog.Companion.showLoadingDialog
import com.movie.popularmovies.ui.home.dialog.RetryDialog

abstract class BaseActivity : AppCompatActivity() {

    abstract fun inject()
    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as BaseApplication).appComponent
            .inject(this)
        super.onCreate(savedInstanceState)
    }


    open fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    open fun showLoading() {
        hideLoading()
        mProgressDialog = showLoadingDialog(this)
    }

    open fun showRetryDialog(retry: Boolean) {
        if (retry) RetryDialog.newInstance().show(supportFragmentManager, RetryDialog::class.simpleName)
    }

}