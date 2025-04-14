package com.dicoding.tourismapp.di

import com.h1194.core.domain.usecase.GamesInteractor
import com.h1194.core.domain.usecase.GamesUseCase
import com.dicoding.tourismapp.detail.DetailTourismViewModel
import com.dicoding.tourismapp.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GamesUseCase> { GamesInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailTourismViewModel(get()) }
}