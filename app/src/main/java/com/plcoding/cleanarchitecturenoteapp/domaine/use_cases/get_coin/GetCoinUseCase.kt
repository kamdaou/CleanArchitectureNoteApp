package com.plcoding.cleanarchitecturenoteapp.domaine.use_cases.get_coin

import com.plcoding.cleanarchitecturenoteapp.common.Resource
import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.toCoinDetail
import com.plcoding.cleanarchitecturenoteapp.domaine.model.Coin
import com.plcoding.cleanarchitecturenoteapp.domaine.model.CoinDetail
import com.plcoding.cleanarchitecturenoteapp.domaine.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: ICoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> {
        return flow {
            try {
                emit(Resource.Loading<CoinDetail>())
                val coin = repository.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success<CoinDetail>(coin))
            }
            catch (e: HttpException) {
                emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "An unexpected error occurred"))
            }
            catch (e: IOException) {
                emit(Resource.Error<CoinDetail>(message = "Couldn't reach the server, check your internet please"))
            }
        }
    }
}
