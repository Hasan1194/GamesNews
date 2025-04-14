package com.h1194.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.h1194.core.data.source.local.entity.GamesEntity

@Database(entities = [GamesEntity::class], version = 6, exportSchema = false)
abstract class GamesDatabase : RoomDatabase() {

    abstract fun tourismDao(): GamesDao

}