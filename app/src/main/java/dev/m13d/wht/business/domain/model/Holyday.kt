package dev.m13d.wht.business.domain.model

data class Holyday(
    var date: String,
    var localName: String,
    var name: String,
    var countryCode: String,
    var fixed: Boolean,
    var global: Boolean,
//    var counties: List<String>,
    var launchYear: Int,
    var type: String,
)