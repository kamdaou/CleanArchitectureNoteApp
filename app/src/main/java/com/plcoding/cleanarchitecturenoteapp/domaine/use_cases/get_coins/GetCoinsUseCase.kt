package com.plcoding.cleanarchitecturenoteapp.domaine.use_cases.get_coins

import com.plcoding.cleanarchitecturenoteapp.common.Resource
import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.toCoin
import com.plcoding.cleanarchitecturenoteapp.domaine.model.Coin
import com.plcoding.cleanarchitecturenoteapp.domaine.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    val repository: ICoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> {
        return flow {
            try {
                emit(Resource.Loading<List<Coin>>())
                val coin = repository.getCoins().map { it.toCoin() }
                emit(Resource.Success<List<Coin>>(coin))
            } catch (e: HttpException) {
                emit(Resource.Error<List<Coin>>(message = e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error<List<Coin>>(message = "Couldn't reach the server, check your internet please"))
            }
        }
    }
}
