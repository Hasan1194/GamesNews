package com.h1194.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.h1194.core.domain.usecase.GamesUseCase

class FavoriteViewModel(gamesUseCase: GamesUseCase) : ViewModel() {
    val favoriteTourism = gamesUseCase.getFavoriteTourism().asLiveData()
}

