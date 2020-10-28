package dev.m13d.wht.datasource.cache

import dev.m13d.wht.datasource.cache.model.HolydayCacheEntity

interface HolydayDaoService {

    suspend fun insert(blogEntity: HolydayCacheEntity): Long

    suspend fun get(): List<HolydayCacheEntity>
}