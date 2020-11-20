package dev.m13d.wht.framework.datasource.network

import dev.m13d.wht.framework.datasource.network.model.HolydayNetworkEntity

interface HolydayRetrofitService {

    suspend fun getCountries(): HashMap<String, String>
    suspend fun get(): List<HolydayNetworkEntity>
}