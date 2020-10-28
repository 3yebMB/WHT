package dev.m13d.wht.business.interactor

import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHolydays
constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) {

    private val TAG: String = "AppDebug"

    suspend fun execute(): Flow<DataState<List<Holyday>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        val networkHolydays = networkDataSource.get()
        cacheDataSource.insertList(networkHolydays)
        val cacheHolydays = cacheDataSource.get()
        emit( DataState.Success(cacheHolydays) )
    }
}