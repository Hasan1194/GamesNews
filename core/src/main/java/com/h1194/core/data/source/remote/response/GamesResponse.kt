package com.h1194.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: String,

    @field:SerializedName("background_image")
    val image: String?
)

