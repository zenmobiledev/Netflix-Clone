package com.mobbelldev.netflixclone.presentation.hot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.domain.entities.movies.Movie
import com.mobbelldev.netflixclone.domain.utils.ImageUtils.toImageUrl

class HotListAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<HotListAdapter.HotListViewHolder>() {
    class HotListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            val posterImageView = itemView.findViewById<ImageView>(R.id.iv_movie_poster)
            Glide.with(itemView.context)
                .load(movie.backdropPath.toImageUrl())
                .centerCrop()
                .into(posterImageView)
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
            val tvMonth = itemView.findViewById<TextView>(R.id.tv_month)
            val tvDate = itemView.findViewById<TextView>(R.id.tv_date)
            val tvDescription = itemView.findViewById<TextView>(R.id.tv_description)
            tvTitle.text = movie.title
            tvMonth.text = movie.releaseDate.substring(5, 7)
            tvDate.text = movie.releaseDate.substring(8, 10)
            tvDescription.text = movie.overview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_list_hot_and_new, parent, false)
        return HotListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: HotListViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }
}