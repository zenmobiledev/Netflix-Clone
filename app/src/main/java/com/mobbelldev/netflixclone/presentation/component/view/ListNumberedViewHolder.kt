package com.mobbelldev.netflixclone.presentation.component.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.presentation.widget.numbered.MovieListNumberedWidget

class ListNumberedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(category: String) {
        val numberedListWidget =
            itemView.findViewById<MovieListNumberedWidget>(R.id.widget_list_numbered)
        numberedListWidget.setCategory(category)
    }
}