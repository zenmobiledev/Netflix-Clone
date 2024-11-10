package com.mobbelldev.netflixclone.domain.entities

data class VideosResponse(
    val id: Int,
    val results: List<VideoResult>,
)

data class VideoResult(
    val iso6391: String,
    val iso31661: String,
    val name: String,
    val key: String,
    val site: String,
    val size: Int = 0,
    val type: String,
    val official: Boolean,
    val publishedAt: String,
    val id: String,
)
