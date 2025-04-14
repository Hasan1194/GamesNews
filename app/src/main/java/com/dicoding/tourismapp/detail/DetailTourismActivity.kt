package com.dicoding.tourismapp.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import com.bumptech.glide.Glide
import com.dicoding.tourismapp.R
import com.h1194.core.domain.model.Games
import com.dicoding.tourismapp.databinding.ActivityDetailTourismBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailTourismActivity : AppCompatActivity() {

   private val detailTourismViewModel: DetailTourismViewModel by viewModel()
    private lateinit var binding: ActivityDetailTourismBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTourismBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

//        hapus kode berikut
//        val factory = ViewModelFactory.getInstance(this)
//        detailTourismViewModel = ViewModelProvider(this, factory)[DetailTourismViewModel::class.java]

        val detailGames = getParcelableExtra(intent, EXTRA_DATA, Games::class.java)
        showDetailTourism(detailGames)
    }

    private fun showDetailTourism(detailGames: Games?) {
        detailGames?.let {
            supportActionBar?.title = detailGames.name
            binding.contentDetailTourism.tvDetailDescription.text = detailGames.rating
            Glide.with(this@DetailTourismActivity)
                .load(detailGames.image)
                .into(binding.ivDetailImage)

            var statusFavorite = detailGames.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTourismViewModel.setFavoriteTourism(detailGames, statusFavorite)
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
