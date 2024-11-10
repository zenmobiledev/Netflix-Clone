package com.mobbelldev.netflixclone.data.source.network

import com.mobbelldev.netflixclone.data.dto.VideosResponseDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieDetailResponseDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieRecommendationsResponseDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    // GENERAL
    @GET("{content_type}/{content_id}/videos")
    suspend fun getVideos(
        @Path("content_type") contentType: String,
        @Path("content_id") contentId: Int,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): VideosResponseDTO

    // Movie
    @GET("movie/{category}")
    suspend fun getMovieList(
        @Path("category") category: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): MovieResponseDTO

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US",
    ): MovieDetailResponseDTO

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMovieRecommendations(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): MovieRecommendationsResponseDTO
}