package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: INetflixRepository) {
    suspend operator fun invoke(movieId: Int) = repository.getMovieDetail(movieId = movieId)
}