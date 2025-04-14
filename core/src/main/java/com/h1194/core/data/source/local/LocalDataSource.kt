package com.h1194.core.data.source.local

import com.h1194.core.data.source.local.entity.GamesEntity
import com.h1194.core.data.source.local.room.GamesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gamesDao: GamesDao) {

//    hapus kode berikut
//    companion object {
//        private var instance: LocalDataSource? = null
//
//        fun getInstance(tourismDao: TourismDao): LocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: LocalDataSource(tourismDao)
//            }
//    }

    fun getAllTourism(): Flow<List<GamesEntity>> = gamesDao.getAllTourism()

    fun getFavoriteTourism(): Flow<List<GamesEntity>> = gamesDao.getFavoriteTourism()

    suspend fun insertTourism(tourismList: List<GamesEntity>) = gamesDao.insertTourism(tourismList)

    fun setFavoriteTourism(tourism: GamesEntity, newState: Boolean) {
        tourism.isFavorite = newState
        gamesDao.updateFavoriteTourism(tourism)
    }
}