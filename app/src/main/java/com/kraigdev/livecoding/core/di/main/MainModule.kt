package com.kraigdev.livecoding.core.di.main

import com.kraigdev.livecoding.modules.Main.data.MainApi
import com.kraigdev.livecoding.modules.Main.data.MainRepositoryImpl
import com.kraigdev.livecoding.modules.Main.domain.GetCategoriesUseCase
import com.kraigdev.livecoding.modules.Main.domain.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object MainModule {

    @Provides
    @ViewModelScoped
    fun provideGetCategoriesUseCases(
        mainRepository: MainRepository
    ) = GetCategoriesUseCase(mainRepository)

    @Provides
    @ViewModelScoped
    fun provideMainRepository(
        mainApi: MainApi
    ): MainRepository = MainRepositoryImpl(
        mainApi = mainApi
    )

    @Provides
    @ViewModelScoped
    fun provideMainApi(
        retrofit: Retrofit
    ): MainApi = retrofit.create(MainApi::class.java)
}