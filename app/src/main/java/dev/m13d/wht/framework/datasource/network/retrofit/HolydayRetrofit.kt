package dev.m13d.wht.framework.datasource.network.retrofit

import dev.m13d.wht.framework.datasource.network.model.HolydayNetworkEntity
import retrofit2.http.GET

interface HolydayRetrofit {

    @GET("PublicHolidays/2020/RU")
    suspend fun getHolyday(): List<HolydayNetworkEntity>

}