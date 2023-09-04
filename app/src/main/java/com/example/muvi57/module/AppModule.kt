package com.example.muvi57.module

import com.example.muvi57.model.MuviApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): MuviApi {
        return Retrofit.Builder().baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(MuviApi::class.java)
    }

}