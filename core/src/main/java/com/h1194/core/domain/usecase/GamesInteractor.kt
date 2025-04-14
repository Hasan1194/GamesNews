package com.h1194.core.domain.usecase

import com.h1194.core.domain.model.Games
import com.h1194.core.domain.repository.IGamesRepository

class GamesInteractor(private val tourismRepository: IGamesRepository): GamesUseCase {

    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(games: Games, state: Boolean) = tourismRepository.setFavoriteTourism(games, state)
}