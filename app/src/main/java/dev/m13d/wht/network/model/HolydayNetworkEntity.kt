package dev.m13d.wht.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class HolydayNetworkEntity(

    @Expose
    @SerializedName("date")
    var date: String,

    @Expose
    @SerializedName("localName")
    val localName: String,

    @Expose
    @SerializedName("name")
    val name: String,

    @Expose
    @SerializedName("countryCode")
    val countryCode: String,

    @Expose
    @SerializedName("fixed")
    val fixed: Boolean,

    @Expose
    @SerializedName("global")
    val global: Boolean,

    @Expose
    @SerializedName("counties")
    val counties: List<String>,

    @Expose
    @SerializedName("launchYear")
    val launchYear: Int,

    @Expose
    @SerializedName("type")
    val type: String,
)