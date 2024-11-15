package com.mobbelldev.netflixclone.di

import com.mobbelldev.netflixclone.domain.repositories.INetflixRepository
import com.mobbelldev.netflixclone.domain.usecases.GetMovieDetailUseCase
import com.mobbelldev.netflixclone.domain.usecases.GetMovieListUseCase
import com.mobbelldev.netflixclone.domain.usecases.GetMovieRecommendations
import com.mobbelldev.netflixclone.domain.usecases.GetVideoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetMovieDetailUseCase(repository: INetflixRepository): GetMovieDetailUseCase {
        return GetMovieDetailUseCase(repository)
    }

    @Provides
    fun provideGetMovieListUseCase(repository: INetflixRepository): GetMovieListUseCase {
        return GetMovieListUseCase(repository)
    }

    @Provides
    fun provideGetMovieRecommendationsUseCase(repository: INetflixRepository): GetMovieRecommendations {
        return GetMovieRecommendations(repository)
    }

    @Provides
    fun provideGetVideoUseCase(repository: INetflixRepository): GetVideoUseCase {
        return GetVideoUseCase(repository)
    }
}