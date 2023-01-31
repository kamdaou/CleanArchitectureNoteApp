package com.plcoding.cleanarchitecturenoteapp.data.repository

import com.plcoding.cleanarchitecturenoteapp.data.remote.CoinPaprikaApi
import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.CoinDetailDto
import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.CoinDto
import com.plcoding.cleanarchitecturenoteapp.domaine.repository.ICoinRepository
import javax.inject.Inject

class CoinRepository @Inject constructor(private val api: CoinPaprikaApi): ICoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoin(id)
    }
}
