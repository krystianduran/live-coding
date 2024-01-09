package com.kraigdev.livecoding.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.chucknorris.io/jokes/"
private const val TIME_DURATION = 15L

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Provides
    @Singleton
    fun provideDispatcher() = Dispatchers.IO

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = OkHttpClient.Builder()
        .readTimeout(TIME_DURATION, TimeUnit.SECONDS)
        .connectTimeout(TIME_DURATION, TimeUnit.SECONDS)
        .build()

    @Provides
    @Singleton
    fun provideMoshi(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(
        provideClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ) = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(provideClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

}