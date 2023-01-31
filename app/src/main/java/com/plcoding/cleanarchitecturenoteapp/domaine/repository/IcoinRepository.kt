package com.plcoding.cleanarchitecturenoteapp.domaine.repository

import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.CoinDetailDto
import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.CoinDto
import retrofit2.http.GET

interface ICoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(id: String): CoinDetailDto
}
