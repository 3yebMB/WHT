package dev.m13d.wht.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.m13d.wht.framework.datasource.cache.model.HolydayCacheEntity

@Dao
interface HolydayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(holydayEntity: HolydayCacheEntity): Long

    @Query("SELECT * FROM holydays")
    suspend fun get(): List<HolydayCacheEntity>

}