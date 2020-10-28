package dev.m13d.wht.business.data.network

import dev.m13d.wht.business.domain.model.Holyday

interface NetworkDataSource {

    suspend fun get(): List<Holyday>
}