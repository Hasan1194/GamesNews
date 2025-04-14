package com.h1194.core.utils

import com.h1194.core.data.source.local.entity.GamesEntity
import com.h1194.core.data.source.remote.response.GamesResponse
import com.h1194.core.domain.model.Games

object DataMapper {
    fun mapResponsesToEntities(input: List<GamesResponse>): List<GamesEntity> {
        val tourismList = ArrayList<GamesEntity>()
        input.map {
            val tourism = GamesEntity(
                tourismId = it.id,
                rating = it.rating,
                name = it.name,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<GamesEntity>): List<Games> =
        input.map {
            Games(
                tourismId = it.tourismId,
                rating = it.rating,
                name = it.name,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Games) = GamesEntity(
        tourismId = input.tourismId,
        rating = input.rating,
        name = input.name,
        image = input.image,
        isFavorite = input.isFavorite
    )
}