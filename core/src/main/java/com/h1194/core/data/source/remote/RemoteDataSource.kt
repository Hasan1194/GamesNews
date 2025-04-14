package com.h1194.core.data.source.remote

import android.util.Log
import com.h1194.core.data.source.remote.network.ApiResponse
import com.h1194.core.data.source.remote.network.ApiService
import com.h1194.core.data.source.remote.response.GamesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTourism(): Flow<ApiResponse<List<GamesResponse>>> {
        val apiKey = "8af566fcf2974a88a165bbd6f7520eda"
        return flow {
            try {
                val response = apiService.getList(apiKey)
                val dataArray = response.places

                Log.d("RemoteDataSource", "API Response: $response")

                if (!dataArray.isNullOrEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", "Error fetching data", e)
            }
        }.flowOn(Dispatchers.IO)
    }
}



