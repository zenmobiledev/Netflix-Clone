package com.mobbelldev.netflixclone.presentation.widget.regular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.domain.entities.movies.Movie
import com.mobbelldev.netflixclone.domain.utils.ImageUtils.toImageUrl

class MovieListRegularAdapter(
    private val movies: List<Movie>,
    private val showPlayButton: Boolean = false,
) : RecyclerView.Adapter<MovieListRegularAdapter.MovieListRegularViewHolder>() {
    class MovieListRegularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie, showPlayButton: Boolean) {
            val posterImageView: ImageView = itemView.findViewById(R.id.iv_movie_poster)
            Glide.with(itemView.context)
                .load(movie.posterPath.toImageUrl())
                .centerCrop()
                .into(posterImageView)
            val ivRank = itemView.findViewById<ImageView>(R.id.iv_rank)
            ivRank.visibility = if (movie.voteAverage > 7) View.VISIBLE else View.GONE
            val playButton = itemView.findViewById<ImageView>(R.id.play_view)
            ivRank.visibility = if (showPlayButton) View.VISIBLE else View.GONE

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListRegularViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_widget_movie_list_regular, parent, false)
        return MovieListRegularViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun onBindViewHolder(holder: MovieListRegularViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie = movie, showPlayButton = showPlayButton)
    }
}