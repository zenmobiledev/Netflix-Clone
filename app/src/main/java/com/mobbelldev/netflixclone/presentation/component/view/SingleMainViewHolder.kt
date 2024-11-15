package com.mobbelldev.netflixclone.presentation.component.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.presentation.widget.MovieListListener
import com.mobbelldev.netflixclone.presentation.widget.singlemain.MovieSingleMainWidget

class SingleMainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind() {
        val singleMainWidget = itemView.findViewById<MovieSingleMainWidget>(R.id.widget_single_main)
//        singleMainWidget.setListener(listener)
    }
}