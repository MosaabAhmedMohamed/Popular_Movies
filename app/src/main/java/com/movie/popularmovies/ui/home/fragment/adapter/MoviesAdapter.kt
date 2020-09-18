package com.movie.popularmovies.ui.home.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.RequestManager
import com.movie.popularmovies.R
import com.movie.popularmovies.data.remote.model.Results
import com.movie.popularmovies.util.OnItemClickListener

class MoviesAdapter(
    private val onItemClickListener: OnItemClickListener,
    DIFF_CALLBACK: DiffUtil.ItemCallback<Results>
) : PagingDataAdapter<Results, ItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ItemViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Results? = getItem(position)
        // Note that item may be null. ViewHolder must support binding a
        // null item as a placeholder.
        item?.let { (holder as ItemViewHolder).onBind(it) }
    }


    object DIFF_CALLBACK : DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.equals(newItem)
        }
    }

}