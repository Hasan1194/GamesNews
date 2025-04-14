package com.h1194.core.data.source.remote.network

import com.h1194.core.data.source.remote.response.ListGamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getList(@Query("key") apiKey: String): ListGamesResponse
}
