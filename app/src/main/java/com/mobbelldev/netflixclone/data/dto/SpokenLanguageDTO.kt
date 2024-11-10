package com.mobbelldev.netflixclone.data.dto

import com.google.gson.annotations.SerializedName

data class SpokenLanguageDTO(
    @SerializedName("english_name") val englishName: String = "",
    @SerializedName("iso_3166_1") val iso31661: String = "",
    @SerializedName("name") val name: String = "",
)
