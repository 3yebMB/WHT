package dev.m13d.wht.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.m13d.wht.business.domain.model.Holyday
import dev.m13d.wht.datasource.cache.database.HolydayDao
import dev.m13d.wht.datasource.cache.database.HolydayDatabase
import dev.m13d.wht.datasource.cache.mapper.CacheMapper
import dev.m13d.wht.datasource.cache.model.HolydayCacheEntity
import dev.m13d.wht.business.domain.util.EntityMapper
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
    fun provideBlogDb(@ApplicationContext context: Context): HolydayDatabase {
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
    fun provideBlogDAO(blogDatabase: HolydayDatabase): HolydayDao {
        return blogDatabase.holydayDao()
    }

    @Singleton
    @Provides
    fun provideBlogDaoService(
        blogDao: HolydayDao
    ):BlogDaoService{
        return BlogDaoServiceImpl(blogDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(
        blogDaoService: BlogDaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource{
        return CacheDataSourceImpl(blogDaoService, cacheMapper)
    }


}