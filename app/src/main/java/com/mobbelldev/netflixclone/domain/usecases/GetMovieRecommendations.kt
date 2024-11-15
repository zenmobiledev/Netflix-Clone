package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository

class GetMovieRecommendations(private val repository: INetflixRepository) {
    suspend operator fun invoke(movieId: Int) = repository.getMovieRecommendation(movieId = movieId)
}