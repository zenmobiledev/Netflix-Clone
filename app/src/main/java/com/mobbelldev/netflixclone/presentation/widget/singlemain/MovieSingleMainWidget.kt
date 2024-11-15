package com.mobbelldev.netflixclone.presentation.widget.singlemain

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.bumptech.glide.Glide
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.domain.utils.ImageUtils.toImageUrl
import com.mobbelldev.netflixclone.presentation.widget.MovieListListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieSingleMainWidget @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

    private lateinit var viewModel: MovieSingleMainViewModel
    private var listener: MovieListListener? = null
    private val ivMoviePoster by lazy {
        findViewById<ImageView>(R.id.iv_movie_poster)
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_widget_movie_single_main, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        initViewModel()
        viewModel.getMovieDetail()
        ivMoviePoster.setOnClickListener {

        }
    }

    private fun initViewModel() {
        val viewModelStoreOwner = findViewTreeViewModelStoreOwner()
        if (viewModelStoreOwner != null) {
            viewModel = ViewModelProvider(viewModelStoreOwner)[MovieSingleMainViewModel::class.java]
            observeLiveData()
        } else {
            throw IllegalStateException("ViewModelStoreOwner not found for MovieSingleMainWidget")
        }
    }

    private fun observeLiveData() {
        findViewTreeLifecycleOwner()?.let { lifecycleOwner: LifecycleOwner ->
            viewModel.movie.observe(lifecycleOwner) { movie ->
                Glide.with(context)
                    .load(movie.posterPath.toImageUrl())
                    .centerCrop()
                    .into(ivMoviePoster)
            }
        }
    }

    fun setListener(listener: MovieListListener) {
        this.listener = listener
    }
}