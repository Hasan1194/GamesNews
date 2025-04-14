package com.h1194.favorite.di

import com.h1194.favorite.detail.FavoriteDetailViewModel
import com.h1194.favorite.ui.FavoriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
    viewModel { FavoriteDetailViewModel(get()) }
}