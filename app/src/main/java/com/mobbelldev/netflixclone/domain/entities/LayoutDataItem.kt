package com.mobbelldev.netflixclone.domain.entities

sealed class LayoutDataItem {
    object SingleMain : LayoutDataItem()
    object Popular : LayoutDataItem()
    object UpComing : LayoutDataItem()
    object NowPlaying : LayoutDataItem()
    object TopRated : LayoutDataItem()
}