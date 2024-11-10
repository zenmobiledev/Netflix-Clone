package com.mobbelldev.netflixclone.domain.repositories

import com.mobbelldev.netflixclone.domain.entities.VideosResponse
import com.mobbelldev.netflixclone.domain.entities.movies.MovieDetail
import com.mobbelldev.netflixclone.domain.entities.movies.MovieRecommendations
import com.mobbelldev.netflixclone.domain.entities.movies.MovieResponse

interface NetflixRepository {
    suspend fun getVideos(contentType: String, contentId: Int): VideosResponse

    suspend fun getMovieList(category: String): MovieResponse

    suspend fun getMovieDetail(movieId: Int): MovieDetail

    suspend fun getMovieRecommendation(movieId: Int): MovieRecommendations
}