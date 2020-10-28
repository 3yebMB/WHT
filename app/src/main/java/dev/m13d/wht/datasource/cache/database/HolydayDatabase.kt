package dev.m13d.wht.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.m13d.wht.datasource.cache.model.HolydayCacheEntity

@Database(entities = [HolydayCacheEntity::class], version = 1)
abstract class HolydayDatabase: RoomDatabase() {
    abstract fun holydayDao(): HolydayDao

    companion object{

        val DATABASE_NAME: String = "holyday_db"
    }
}
