package com.plcoding.cleanarchitecturenoteapp.di

import com.plcoding.cleanarchitecturenoteapp.common.Constants
import com.plcoding.cleanarchitecturenoteapp.data.remote.CoinPaprikaApi
import com.plcoding.cleanarchitecturenoteapp.data.repository.CoinRepository
import com.plcoding.cleanarchitecturenoteapp.domaine.repository.ICoinRepository
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

    @Singleton
    @Provides
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: CoinPaprikaApi): ICoinRepository {
        return CoinRepository(api)
    }
}
