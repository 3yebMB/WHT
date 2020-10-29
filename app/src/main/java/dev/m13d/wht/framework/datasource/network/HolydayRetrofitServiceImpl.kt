package dev.m13d.wht.framework.datasource.network

import dev.m13d.wht.framework.datasource.network.model.HolydayNetworkEntity
import dev.m13d.wht.framework.datasource.network.retrofit.HolydayRetrofit

class HolydayRetrofitServiceImpl
constructor(
    private val holydayRetrofit: HolydayRetrofit
): HolydayRetrofitService {

    override suspend fun get(): List<HolydayNetworkEntity> {
        return holydayRetrofit.get()
    }
}