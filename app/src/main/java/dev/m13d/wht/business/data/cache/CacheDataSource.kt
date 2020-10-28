package dev.m13d.wht.business.data.cache

import dev.m13d.wht.business.domain.model.Holyday

interface CacheDataSource {

    suspend fun insert(holyday: Holyday): Long

    suspend fun insertList(holydays: List<Holyday>)

    suspend fun get(): List<Holyday>
}