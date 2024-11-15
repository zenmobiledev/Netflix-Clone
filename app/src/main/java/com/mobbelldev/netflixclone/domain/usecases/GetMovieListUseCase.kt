package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(private val repository: INetflixRepository) {
    suspend operator fun invoke(category: String) = repository.getMovieList(category = category)
}