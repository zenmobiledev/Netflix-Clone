package com.mobbelldev.netflixclone.presentation.widget.singlemain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.netflixclone.domain.entities.movies.MovieDetail
import com.mobbelldev.netflixclone.domain.usecases.GetMovieDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSingleMainViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {

    private val _movie = MutableLiveData<MovieDetail>()
    val movie: LiveData<MovieDetail> = _movie

    fun getMovieDetail() {
        viewModelScope.launch {
            try {
                val movie = getMovieDetailUseCase.invoke(129)
                _movie.value = movie
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }
}