package dev.m13d.wht.framework.datasource.cache

import dev.m13d.wht.framework.datasource.cache.model.HolydayCacheEntity

interface HolydayDaoService {

    suspend fun insert(holydayEntity: HolydayCacheEntity): Long

    suspend fun get(): List<HolydayCacheEntity>
}