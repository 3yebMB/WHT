package dev.m13d.wht.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.m13d.wht.business.data.cache.CacheDataSource
import dev.m13d.wht.business.data.cache.CacheDataSourceImpl
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.datasource.cache.database.HolydayDao
import dev.m13d.wht.datasource.cache.database.HolydayDatabase
import dev.m13d.wht.datasource.cache.mapper.CacheMapper
import dev.m13d.wht.datasource.cache.model.HolydayCacheEntity
import dev.m13d.wht.business.domain.util.EntityMapper
import dev.m13d.wht.datasource.cache.HolydayDaoService
import dev.m13d.wht.datasource.cache.HolydayDaoServiceImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<HolydayCacheEntity, Holyday> {
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideHolydayDb(@ApplicationContext context: Context): HolydayDatabase {
        return Room
            .databaseBuilder(
                context,
                HolydayDatabase::class.java,
                HolydayDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideHolydayDAO(holydayDatabase: HolydayDatabase): HolydayDao {
        return holydayDatabase.holydayDao()
    }

    @Singleton
    @Provides
    fun provideHolydayDaoService(
        holydayDao: HolydayDao
    ): HolydayDaoService {
        return HolydayDaoServiceImpl(holydayDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(
        blogDaoService: HolydayDaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource {
        return CacheDataSourceImpl(blogDaoService, cacheMapper)
    }


}