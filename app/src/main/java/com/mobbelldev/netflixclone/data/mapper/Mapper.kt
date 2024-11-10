package com.mobbelldev.netflixclone.data.mapper

import com.mobbelldev.netflixclone.data.dto.GenreDTO
import com.mobbelldev.netflixclone.data.dto.ProductionCompanyDTO
import com.mobbelldev.netflixclone.data.dto.ProductionCountryDTO
import com.mobbelldev.netflixclone.data.dto.SpokenLanguageDTO
import com.mobbelldev.netflixclone.data.dto.VideoResultDTO
import com.mobbelldev.netflixclone.data.dto.VideosResponseDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieDetailResponseDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieRecommendationResultDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieRecommendationsResponseDTO
import com.mobbelldev.netflixclone.data.dto.movies.MovieResponseDTO
import com.mobbelldev.netflixclone.domain.entities.Genre
import com.mobbelldev.netflixclone.domain.entities.ProductionCompany
import com.mobbelldev.netflixclone.domain.entities.ProductionCountry
import com.mobbelldev.netflixclone.domain.entities.SpokenLanguage
import com.mobbelldev.netflixclone.domain.entities.VideoResult
import com.mobbelldev.netflixclone.domain.entities.VideosResponse
import com.mobbelldev.netflixclone.domain.entities.movies.Movie
import com.mobbelldev.netflixclone.domain.entities.movies.MovieDetail
import com.mobbelldev.netflixclone.domain.entities.movies.MovieRecommendationResult
import com.mobbelldev.netflixclone.domain.entities.movies.MovieRecommendations
import com.mobbelldev.netflixclone.domain.entities.movies.MovieResponse

class Mapper {

    fun mapVideosResponse(videosResponseDTO: VideosResponseDTO): VideosResponse {
        return videosResponseDTO.toVideoResponse()
    }

    fun mapMovieResponse(movieResponseDTO: MovieResponseDTO): MovieResponse {
        return movieResponseDTO.toMovieResponse()
    }

    fun mapMovieDetailResponse(movieDetailResponseDTO: MovieDetailResponseDTO): MovieDetail {
        return movieDetailResponseDTO.toMovieDetails()
    }

    fun mapMovieRecommendationsResponse(movieRecommendationsResponseDTO: MovieRecommendationsResponseDTO): MovieRecommendations {
        return movieRecommendationsResponseDTO.toMovieRecommendationResponse()
    }

    private fun MovieRecommendationsResponseDTO.toMovieRecommendationResponse(): MovieRecommendations {
        return MovieRecommendations(
            page = page,
            results = results.map { it.toMovieRecommendationResult() },
            totalPages = totalPages,
            totalResults = totalResults
        )
    }

    private fun MovieRecommendationResultDTO.toMovieRecommendationResult(): MovieRecommendationResult {
        return MovieRecommendationResult(
            adult = adult,
            backdropPath = backdropPath,
            genreIds = genreIds,
            id = id,
            mediaType = mediaType,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }

    private fun MovieDetailResponseDTO.toMovieDetails(): MovieDetail {
        return MovieDetail(
            adult = adult,
            backdropPath = backdropPath,
            belongsToCollection = belongsToCollection,
            budget = budget,
            genreIds = genreIds.map { it.toGenre() },
            homepage = homepage,
            id = id,
            imdbId = imdbId,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            productionCompanies = productionCompanies.map { it.toProductionCompany() },
            productionCountries = productionCountries.map { it.toProductionCountry() },
            releaseDate = releaseDate,
            revenue = revenue,
            runtime = runtime,
            spokenLanguage = spokenLanguage.map { it.toSpokenLanguage() },
            status = status,
            tagline = tagline,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount,
            originCountry = originCountry
        )
    }

    private fun MovieResponseDTO.toMovieResponse(): MovieResponse {
        return MovieResponse(
            page = page,
            results = results.map { it.toMovie() },
            totalPages = totalPages,
            totalResults = totalResults
        )
    }

    private fun MovieDTO.toMovie(): Movie {
        return Movie(
            adult = adult,
            backdropPath = backdropPath,
            genreIds = genreIds,
            id = id,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            overview = overview,
            popularity = popularity,
            posterPath = posterPath,
            releaseDate = releaseDate,
            title = title,
            video = video,
            voteAverage = voteAverage,
            voteCount = voteCount
        )
    }

    private fun GenreDTO.toGenre(): Genre {
        return Genre(
            id = id,
            name = name
        )
    }

    private fun ProductionCompanyDTO.toProductionCompany(): ProductionCompany {
        return ProductionCompany(
            id = id,
            logoPath = logoPath,
            name = name,
            originCountry = originCountry
        )
    }

    private fun ProductionCountryDTO.toProductionCountry(): ProductionCountry {
        return ProductionCountry(
            iso31661 = iso31661,
            name = name
        )
    }

    private fun SpokenLanguageDTO.toSpokenLanguage(): SpokenLanguage {
        return SpokenLanguage(
            englishName = englishName,
            iso31661 = iso31661,
            name = name
        )
    }

    private fun VideosResponseDTO.toVideoResponse(): VideosResponse {
        return VideosResponse(
            id = id,
            results = results.map { it.toVideoResult() }
        )
    }

    private fun VideoResultDTO.toVideoResult(): VideoResult {
        return VideoResult(
            iso6391 = iso6391,
            iso31661 = iso31661,
            name = name,
            key = key,
            site = site,
            size = size,
            type = type,
            official = official,
            publishedAt = publishedAt,
            id = id
        )
    }
}