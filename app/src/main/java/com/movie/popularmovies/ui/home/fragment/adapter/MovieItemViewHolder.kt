package com.movie.popularmovies.ui.home.fragment.adapter

import android.view.View
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.bumptech.glide.RequestManager
import com.movie.popularmovies.R
import com.movie.popularmovies.data.remote.model.Results
import com.movie.popularmovies.ui.base.BaseViewHolder
import com.movie.popularmovies.util.Constants.Companion.POSTER_BASE_URL
import com.movie.popularmovies.util.OnItemClickListener
import com.movie.popularmovies.util.extintion.logD
import kotlinx.android.synthetic.main.item_movie.view.*
import timber.log.Timber
import timber.log.Timber.log
import java.lang.StrictMath.log
import kotlin.math.log

class ItemViewHolder(
    itemView: View?,
    val itemClickListener: OnItemClickListener
): BaseViewHolder<Results>(itemView) {



    override fun onBind(item: Results) {
        try {
            itemView.cv_iv_movie_poster.load(POSTER_BASE_URL.plus(item.poster_path)) {
                crossfade(true)
                    .error(R.drawable.ic_movie)
                    .placeholder(R.drawable.ic_movie)
                transformations(RoundedCornersTransformation(10F))
            }
            itemView.cv_movie_release_date.text = item.release_date
            itemView.cv_movie_title.text = item.title
            itemView.setOnClickListener { itemClickListener.onClick(item.id) }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

}