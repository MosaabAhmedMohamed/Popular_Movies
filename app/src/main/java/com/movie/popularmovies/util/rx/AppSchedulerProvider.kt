package com.movie.popularmovies.util.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class AppSchedulerProvider : SchedulerProvider {

    object instance : AppSchedulerProvider()

    override fun computation(): Scheduler? {
        return Schedulers.computation()
    }

    override fun io(): Scheduler? {
        return Schedulers.io()
    }

    override fun ui(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}