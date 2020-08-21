package com.movie.popularmovies.ui.home.fragment.adapter

import android.view.View
import com.bumptech.glide.RequestManager
import com.movie.popularmovies.data.remote.model.Results
import com.movie.popularmovies.ui.base.BaseViewHolder
import com.movie.popularmovies.util.Constants.Companion.POSTER_BASE_URL
import com.movie.popularmovies.util.OnItemClickListener
import kotlinx.android.synthetic.main.item_movie.view.*

class ItemViewHolder(
    itemView: View?,
    val itemClickListener: OnItemClickListener,
    val requestManager: RequestManager
): BaseViewHolder<Results>(itemView) {



    override fun onBind(item: Results) {
        try {

            requestManager.load(POSTER_BASE_URL.plus(item.poster_path))
                .into(itemView.cv_iv_movie_poster)
            itemView.cv_movie_release_date.text = item.release_date
            itemView.cv_movie_title.text = item.title
            itemView.setOnClickListener { itemClickListener.onClick(item.id) }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

}