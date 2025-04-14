package com.h1194.core.data

import com.h1194.core.data.source.local.LocalDataSource
import com.h1194.core.data.source.remote.RemoteDataSource
import com.h1194.core.data.source.remote.network.ApiResponse
import com.h1194.core.data.source.remote.response.GamesResponse
import com.h1194.core.domain.model.Games
import com.h1194.core.domain.repository.IGamesRepository
import com.h1194.core.utils.AppExecutors
import com.h1194.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGamesRepository {

//    hapus kode berikut
//    companion object {
//        @Volatile
//        private var instance: TourismRepository? = null
//
//        fun getInstance(
//            remoteData: RemoteDataSource,
//            localData: LocalDataSource,
//            appExecutors: AppExecutors
//        ): TourismRepository =
//            instance ?: synchronized(this) {
//                instance ?: TourismRepository(remoteData, localData, appExecutors)
//            }
//    }

    override fun getAllTourism(): Flow<com.h1194.core.data.Resource<List<Games>>> =
        object : com.h1194.core.data.NetworkBoundResource<List<Games>, List<GamesResponse>>() {
            override fun loadFromDB(): Flow<List<Games>> {
                return localDataSource.getAllTourism().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Games>?): Boolean =
                data.isNullOrEmpty() // mengambil data dari internet hanya jika data di database kosong
//                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponse>>> =
                remoteDataSource.getAllTourism()

            override suspend fun saveCallResult(data: List<GamesResponse>) {
                val tourismList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTourism(tourismList)
            }
        }.asFlow()

    override fun getFavoriteTourism(): Flow<List<Games>> {
        return localDataSource.getFavoriteTourism().map {
           DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTourism(games: Games, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(games)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTourism(tourismEntity, state) }
    }
}

