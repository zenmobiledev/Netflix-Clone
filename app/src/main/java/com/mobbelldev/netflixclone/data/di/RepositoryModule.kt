package com.mobbelldev.netflixclone.data.di

import com.mobbelldev.netflixclone.data.mapper.Mapper
import com.mobbelldev.netflixclone.data.repositories.INetflixRepositoryImpl
import com.mobbelldev.netflixclone.data.source.network.ApiService
import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMapper(): Mapper {
        return Mapper()
    }

    @Provides
    @Singleton
    fun provideINetflixRepositoryImpl(
        apiService: ApiService,
        mapper: Mapper,
    ): INetflixRepository {
        return INetflixRepositoryImpl(
            apiService = apiService,
            mapper = mapper
        )
    }
}