package dev.m13d.wht.framework.datasource.cache

import dev.m13d.wht.framework.datasource.cache.database.HolydayDao
import dev.m13d.wht.framework.datasource.cache.model.HolydayCacheEntity

class HolydayDaoServiceImpl
constructor(
    private val holydayDao: HolydayDao
): HolydayDaoService {

    override suspend fun insert(holydayCacheEntity: HolydayCacheEntity): Long {
        return holydayDao.insert(holydayCacheEntity)
    }

    override suspend fun get(): List<HolydayCacheEntity> {
        return holydayDao.get()
    }
}