package dev.m13d.wht.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.m13d.wht.business.data.network.NetworkDataSource
import dev.m13d.wht.business.data.network.NetworkDataSourceImpl
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.business.domain.util.EntityMapper
import dev.m13d.wht.framework.datasource.network.HolydayRetrofitService
import dev.m13d.wht.framework.datasource.network.HolydayRetrofitServiceImpl
import dev.m13d.wht.framework.datasource.network.mapper.NetworkMapper
import dev.m13d.wht.framework.datasource.network.model.HolydayNetworkEntity
import dev.m13d.wht.framework.datasource.network.retrofit.HolydayRetrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<HolydayNetworkEntity, Holyday> {
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson:  Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://date.nager.at/Api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideHolydayService(retrofit: Retrofit.Builder): HolydayRetrofit {
        return retrofit
            .build()
            .create(HolydayRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitService(
        holydayRetrofit: HolydayRetrofit
    ): HolydayRetrofitService {
        return HolydayRetrofitServiceImpl(holydayRetrofit)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        holydayRetrofitService: HolydayRetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(holydayRetrofitService, networkMapper)
    }
}