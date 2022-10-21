package com.example.technicalexam.di

import com.example.technicalexam.data.repository.ApiRepository
import com.example.technicalexam.data.repository.ApiService
import com.example.technicalexam.domain.ApiRepositoryDomain
import com.example.technicalexam.ui.Constants
import com.example.technicalexam.ui.getApiClient
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun providesApi(): ApiService {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(getApiClient().build())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesApiRepository(api: ApiService): ApiRepositoryDomain = ApiRepository(api)

}