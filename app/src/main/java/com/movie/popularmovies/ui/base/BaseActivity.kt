package com.movie.popularmovies.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.movie.popularmovies.ui.custom.LoadingProgressDialog.Companion.showLoadingDialog
import com.movie.popularmovies.ui.home.dialog.RetryDialog
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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