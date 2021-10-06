package com.example.hyper_onetask_romanywageed.di

import com.example.hyper_onetask_romanywageed.utlis.BASE_URL
import com.example.hyper_onetask_romanywageed.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(Base_URL:String) : ApiService =
        Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}