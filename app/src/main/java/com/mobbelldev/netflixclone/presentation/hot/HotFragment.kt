package com.mobbelldev.netflixclone.presentation.hot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobbelldev.netflixclone.R
import com.mobbelldev.netflixclone.domain.entities.movies.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HotFragment : Fragment() {

    private lateinit var rvMovieList: RecyclerView
    private val viewModel: HotViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        viewModel.getMovieList("now_playing")
    }

    private fun observeData() {
        viewModel.movieList.observe(viewLifecycleOwner) { movies ->
            initList(movies)
        }
    }

    private fun initList(movies: List<Movie>) {
        view?.let {
            rvMovieList = it.findViewById(R.id.rv_hot)
            rvMovieList.adapter = HotListAdapter(
                movies = movies
            )
            rvMovieList.layoutManager = LinearLayoutManager(context)
        }
    }
}