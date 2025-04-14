package com.h1194.core.domain.usecase

import com.h1194.core.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface GamesUseCase {
    fun getAllTourism(): Flow<com.h1194.core.data.Resource<List<Games>>>
    fun getFavoriteTourism(): Flow<List<Games>>
    fun setFavoriteTourism(games: Games, state: Boolean)
}