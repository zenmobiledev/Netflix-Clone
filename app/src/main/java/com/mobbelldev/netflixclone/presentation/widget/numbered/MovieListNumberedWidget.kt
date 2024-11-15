package com.mobbelldev.netflixclone.presentation.widget.numbered

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbelldev.netflixclone.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListNumberedWidget @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private lateinit var viewModel: MovieListNumberedViewModel

    private val tvTitle by lazy {
        findViewById<TextView>(R.id.tv_title)
    }
    private val rvMoviePoster by lazy {
        findViewById<RecyclerView>(R.id.rv_movie_poster)
    }

    private var category = "popular"

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_widget_movie_list_numbered, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initViewModel()
        viewModel.getMovieList(category)
    }

    private fun initViewModel() {
        val viewModelStoreOwner = findViewTreeViewModelStoreOwner()
        if (viewModelStoreOwner != null) {
            viewModel =
                ViewModelProvider(viewModelStoreOwner)[MovieListNumberedViewModel::class.java]
            observeLiveData()
        } else {
            throw IllegalStateException("ViewModelStoreOwner not found for MovieSingleMainWidget")
        }
    }

    private fun observeLiveData() {
        findViewTreeLifecycleOwner()?.let { lifecycleOwner: LifecycleOwner ->
            viewModel.movieList.observe(lifecycleOwner) { movieList ->
                val movieListNumberedAdapter = MovieListNumberedAdapter(
                    movies = movieList
                )
                rvMoviePoster.apply {
                    adapter = movieListNumberedAdapter
                    layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
        }
    }

    fun setCategory(category: String) {
        this.category = category
        tvTitle.text
    }
}