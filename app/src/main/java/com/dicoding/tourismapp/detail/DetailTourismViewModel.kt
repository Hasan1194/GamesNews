package com.dicoding.tourismapp.detail

import androidx.lifecycle.ViewModel
import com.h1194.core.domain.model.Games
import com.h1194.core.domain.usecase.GamesUseCase

class DetailTourismViewModel(private val gamesUseCase: GamesUseCase) : ViewModel() {
    fun setFavoriteTourism(games: Games, newStatus:Boolean) =
        gamesUseCase.setFavoriteTourism(games, newStatus)
}

