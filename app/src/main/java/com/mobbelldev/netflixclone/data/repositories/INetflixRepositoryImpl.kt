package com.mobbelldev.netflixclone.data.repositories

import com.mobbelldev.netflixclone.data.mapper.Mapper
import com.mobbelldev.netflixclone.data.source.network.ApiService
import com.mobbelldev.netflixclone.domain.entities.VideosResponse
import com.mobbelldev.netflixclone.domain.entities.movies.MovieDetail
import com.mobbelldev.netflixclone.domain.entities.movies.MovieRecommendations
import com.mobbelldev.netflixclone.domain.entities.movies.MovieResponse
import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository
import javax.inject.Inject

class INetflixRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: Mapper,
) : INetflixRepository {
    override suspend fun getVideos(contentType: String, contentId: Int): VideosResponse {
        val response = apiService.getVideos(
            contentType = contentType,
            contentId = contentId
        )

        return mapper.mapVideosResponse(videosResponseDTO = response)
    }

    override suspend fun getMovieList(category: String): MovieResponse {
        val response = apiService.getMovieList(category = category)

        return mapper.mapMovieResponse(movieResponseDTO = response)
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail {
        val response = apiService.getMovieDetail(movieId = movieId)

        return mapper.mapMovieDetailResponse(movieDetailResponseDTO = response)
    }

    override suspend fun getMovieRecommendation(movieId: Int): MovieRecommendations {
        val response = apiService.getMovieRecommendations(movieId = movieId)

        return mapper.mapMovieRecommendationsResponse(movieRecommendationsResponseDTO = response)
    }
}