package com.mobbelldev.netflixclone.presentation.widget.regular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobbelldev.netflixclone.domain.entities.movies.Movie
import com.mobbelldev.netflixclone.domain.usecases.GetMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListRegularViewModel @Inject constructor(private val getMovieListUseCase: GetMovieListUseCase) :
    ViewModel() {

    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    fun getMovieList(category: String) {
        viewModelScope.launch {
            try {
                val movie = getMovieListUseCase.invoke(category)
                _movieList.value = movie.results
            } catch (t: Throwable) {
                // do nothing
            }
        }
    }
}