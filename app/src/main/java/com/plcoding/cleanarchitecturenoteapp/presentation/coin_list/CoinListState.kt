package com.plcoding.cleanarchitecturenoteapp.presentation.coin_list

import com.plcoding.cleanarchitecturenoteapp.domaine.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
