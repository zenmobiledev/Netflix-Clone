package com.mobbelldev.netflixclone.domain.entities.movies

import com.mobbelldev.netflixclone.domain.entities.Genre
import com.mobbelldev.netflixclone.domain.entities.ProductionCompany
import com.mobbelldev.netflixclone.domain.entities.ProductionCountry
import com.mobbelldev.netflixclone.domain.entities.SpokenLanguage

data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: Any?,
    val budget: Int = 0,
    val genreIds: List<Genre>,
    val homepage: String,
    val id: Int = 0,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double = 0.0,
    val posterPath: String,
    val productionCompanies: List<ProductionCompany>,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int = 0,
    val runtime: Int = 0,
    val spokenLanguage: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int = 0,
    val originCountry: List<String>,
)
