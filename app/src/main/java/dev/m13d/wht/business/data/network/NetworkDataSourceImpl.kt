package dev.m13d.wht.business.data.network

import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.framework.datasource.network.HolydayRetrofitService
import dev.m13d.wht.framework.datasource.network.mapper.NetworkMapper

class NetworkDataSourceImpl
constructor(
    private val holydayRetrofitService: HolydayRetrofitService,
    private val networkMapper: NetworkMapper
): NetworkDataSource{

    override suspend fun get(): List<Holyday> {
        return networkMapper.mapFromEntityList(holydayRetrofitService.get())
    }

}