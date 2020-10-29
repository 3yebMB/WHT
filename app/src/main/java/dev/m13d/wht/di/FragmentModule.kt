package dev.m13d.wht.di

import androidx.fragment.app.FragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dev.m13d.wht.framework.presentation.MainFragmentFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(ApplicationComponent::class)
object FragmentModule {

    @Singleton
    @Provides
    fun provideMainFragmentFactory(someString: String): FragmentFactory {
        return MainFragmentFactory(someString)
    }
}