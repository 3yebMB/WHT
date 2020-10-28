package dev.m13d.wht.framework.datasource.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "holydays")
data class HolydayCacheEntity(

    @ColumnInfo(name = "date")
    var date: String,

    @ColumnInfo(name = "localName")
    var localName: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "countryCode")
    var countryCode: String,

    @ColumnInfo(name = "fixed")
    var fixed: Boolean,

    @ColumnInfo(name = "global")
    var global: Boolean,

    @ColumnInfo(name = "counties")
    var counties: List<String>,

    @ColumnInfo(name = "launchYear")
    var launchYear: Int,

    @ColumnInfo(name = "type")
    var type: String
)