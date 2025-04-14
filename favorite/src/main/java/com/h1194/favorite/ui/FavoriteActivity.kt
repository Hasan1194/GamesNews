package com.h1194.favorite.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.tourismapp.ui.GamesAdapter
import com.dicoding.tourismapp.detail.DetailTourismActivity
import com.h1194.favorite.detail.FavoriteDetailActivity
import com.h1194.favorite.databinding.ActivityFavoriteBinding
import com.h1194.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        val gamesAdapter = GamesAdapter()
        gamesAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, FavoriteDetailActivity::class.java)
            intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTourism.observe(this) { dataTourism ->
            gamesAdapter.submitList(dataTourism)
        }

        with(binding.rvTourism) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = gamesAdapter
        }
    }
}
