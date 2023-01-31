package com.plcoding.cleanarchitecturenoteapp.presentation.coin_detail

import com.plcoding.cleanarchitecturenoteapp.domaine.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
