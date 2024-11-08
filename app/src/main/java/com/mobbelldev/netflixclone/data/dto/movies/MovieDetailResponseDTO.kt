package com.mobbelldev.netflixclone.data.dto.movies

import com.mobbelldev.netflixclone.data.dto.GenreDTO
import com.mobbelldev.netflixclone.data.dto.ProductionCompanyDTO
import com.mobbelldev.netflixclone.data.dto.ProductionCountryDTO
import com.mobbelldev.netflixclone.data.dto.SpokenLanguageDTO

data class MovieDetailResponseDTO(
    @SerializedName("adult") val adult: Boolean = false,
    @SerializedName("backdrop_path") val backdropPath: String = "",
    @SerializedName("belongs_to_collection") val belongsToCollection: Any?,
    @SerializedName("budget") val budget: Int = 0,
    @SerializedName("genres") val genreIds: List<GenreDTO> = emptyList(),
    @SerializedName("homepage") val homepage: String = "",
    @SerializedName("id") val id: Int = 0,
    @SerializedName("imdb_id") val imdbId: String = "",
    @SerializedName("original_language") val originalLanguage: String = "",
    @SerializedName("original_title") val originalTitle: String = "",
    @SerializedName("overview") val overview: String = "",
    @SerializedName("popularity") val popularity: Double = 0.0,
    @SerializedName("poster_path") val posterPath: String = "",
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyDTO> = emptyList(),
    @SerializedName("production_countries") val productionCountries: List<ProductionCountryDTO> = emptyList(),
    @SerializedName("release_date") val releaseDate: String = "",
    @SerializedName("revenue") val revenue: Int = 0,
    @SerializedName("runtime") val runtime: Int = 0,
    @SerializedName("spoken_language") val spokenLanguage: List<SpokenLanguageDTO> = emptyList(),
    @SerializedName("status") val status: String = "",
    @SerializedName("tagline") val tagline: String = "",
    @SerializedName("title") val title: String = "",
    @SerializedName("video") val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("vote_count") val voteCount: Int = 0,
    @SerializedName("origin_country") val originCountry: List<String> = emptyList(),
)
