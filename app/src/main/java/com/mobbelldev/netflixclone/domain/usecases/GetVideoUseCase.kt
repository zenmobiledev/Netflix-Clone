package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.NetflixRepository

class GetVideoUseCase(private val repository: NetflixRepository) {
    suspend operator fun invoke(contentType: String, contentId: Int) = repository.getVideos(
        contentType = contentType,
        contentId = contentId
    )
}