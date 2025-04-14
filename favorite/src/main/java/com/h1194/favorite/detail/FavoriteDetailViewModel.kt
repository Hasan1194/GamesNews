package com.h1194.favorite.detail

import androidx.lifecycle.ViewModel
import com.h1194.core.domain.model.Games
import com.h1194.core.domain.usecase.GamesUseCase

class FavoriteDetailViewModel(private val gamesUseCase: GamesUseCase) : ViewModel() {
    fun setFavoriteTourism(games: Games, newStatus: Boolean) =
        gamesUseCase.setFavoriteTourism(games, newStatus)
}