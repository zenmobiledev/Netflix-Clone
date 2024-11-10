package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.NetflixRepository

class GetMovieListUseCase(private val repository: NetflixRepository) {
    suspend operator fun invoke(category: String) = repository.getMovieList(category = category)
}