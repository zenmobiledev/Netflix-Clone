package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.NetflixRepository

class GetMovieRecommendations(private val repository: NetflixRepository) {
    suspend operator fun invoke(movieId: Int) = repository.getMovieRecommendation(movieId = movieId)
}