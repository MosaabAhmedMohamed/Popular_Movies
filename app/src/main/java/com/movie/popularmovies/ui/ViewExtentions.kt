package com.movie.popularmovies.ui

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes

fun Activity.displayToast(
    @StringRes message: Int
) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.displayToast(
    message: String
) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}
