package dev.m13d.wht.business.data.cache

import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.framework.datasource.cache.HolydayDaoService
import dev.m13d.wht.framework.datasource.cache.mapper.CacheMapper

class CacheDataSourceImpl
constructor(
    private val holydayDaoService: HolydayDaoService,
    private val cacheMapper: CacheMapper
): CacheDataSource{

    override suspend fun insert(holyday: Holyday): Long {
        return holydayDaoService.insert(cacheMapper.mapToEntity(holyday))
    }

    override suspend fun insertList(holydays: List<Holyday>){
        for(holyday in holydays) {
            holydayDaoService.insert(cacheMapper.mapToEntity(holyday))
        }
    }

    override suspend fun get(): List<Holyday> {
        return cacheMapper.mapFromEntityList(holydayDaoService.get())
    }
}
