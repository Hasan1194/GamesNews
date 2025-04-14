package com.dicoding.tourismapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.h1194.core.R
import com.h1194.core.databinding.ItemListTourismBinding
import com.h1194.core.domain.model.Games

class GamesAdapter : ListAdapter<Games, GamesAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Games) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemListTourismBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Games) {
            Glide.with(itemView.context)
                .load(data.image)
                .placeholder(R.drawable.image_placeholder)
                .into(binding.ivItemImage)
            binding.tvItemTitle.text = data.name
            binding.tvItemSubtitle.text = data.rating
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Games> =
            object : DiffUtil.ItemCallback<Games>() {
                override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
                    return oldItem.tourismId == newItem.tourismId
                }

                override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
                    return oldItem == newItem
                }
            }
    }
}