package com.h1194.core.data.source.local.room

import androidx.room.*
import com.h1194.core.data.source.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {

    @Query("SELECT * FROM games")
    fun getAllTourism(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM games where isFavorite = 1")
    fun getFavoriteTourism(): Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourism(tourism: List<GamesEntity>)

    @Update
    fun updateFavoriteTourism(tourism: GamesEntity)
}
