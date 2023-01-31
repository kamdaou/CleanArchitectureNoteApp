package com.plcoding.cleanarchitecturenoteapp.domaine.model

import com.plcoding.cleanarchitecturenoteapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val description: String,
    val name: String,
    val team: List<TeamMember>,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>
)
