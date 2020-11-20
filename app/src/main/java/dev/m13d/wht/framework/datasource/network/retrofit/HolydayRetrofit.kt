package dev.m13d.wht.framework.datasource.network.retrofit

import dev.m13d.wht.framework.datasource.network.model.HolydayNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface HolydayRetrofit {

    @GET("AvailableCountries")
    @Headers("Content-Type: application/json")
    suspend fun getCountries() : HashMap<String, String>

    @GET("PublicHolidays/2020/{CountryCode}}")
    @Headers("Content-Type: application/json")
    suspend fun get(@Path("CountryCode") CountryCode: String): List<HolydayNetworkEntity>
}