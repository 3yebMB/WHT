package dev.m13d.wht.framework.datasource.network

import dev.m13d.wht.framework.datasource.network.model.CountryNetworkEntity
import dev.m13d.wht.framework.datasource.network.model.HolydayNetworkEntity

interface HolydayRetrofitService {

    suspend fun getCountries(): List<CountryNetworkEntity>
    suspend fun get(): List<HolydayNetworkEntity>
}