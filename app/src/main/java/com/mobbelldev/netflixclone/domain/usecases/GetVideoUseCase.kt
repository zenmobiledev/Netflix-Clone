package com.mobbelldev.netflixclone.domain.usecases

import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository

class GetVideoUseCase(private val repository: INetflixRepository) {
    suspend operator fun invoke(contentType: String, contentId: Int) = repository.getVideos(
        contentType = contentType,
        contentId = contentId
    )
}