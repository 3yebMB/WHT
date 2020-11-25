package dev.m13d.wht.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryNetworkEntity (

        @Expose
        @SerializedName("key")
        var countryCode: String,

        @Expose
        @SerializedName("value")
        var countryName: String,
)