package com.h1194.favorite.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.R
import com.dicoding.tourismapp.databinding.ActivityDetailTourismBinding
import com.h1194.core.domain.model.Games
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteDetailActivity : AppCompatActivity() {
    private val favoriteDetailViewModel: FavoriteDetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailGames = getParcelableExtra(intent, EXTRA_DATA, Games::class.java)
        showDetailTourism(detailGames)
    }

    private fun showDetailTourism(detailGames: Games?) {
        detailGames?.let {
            supportActionBar?.title = detailGames.name
            binding.contentDetailTourism.tvDetailDescription.text = detailGames.rating
            Glide.with(this@FavoriteDetailActivity)
                .load(detailGames.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailGames.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                favoriteDetailViewModel.setFavoriteTourism(detailGames, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}