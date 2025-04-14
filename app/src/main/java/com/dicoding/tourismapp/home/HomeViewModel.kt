package com.dicoding.tourismapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.h1194.core.domain.usecase.GamesUseCase

class HomeViewModel(gamesUseCase: GamesUseCase) : ViewModel() {
    val tourism = gamesUseCase.getAllTourism().asLiveData()
}

