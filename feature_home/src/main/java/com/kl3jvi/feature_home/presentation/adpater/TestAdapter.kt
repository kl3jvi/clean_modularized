package com.kl3jvi.feature_home.presentation.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.domain.model.MovieListDomainModel
import com.kl3jvi.feature_home.databinding.ItemMovieLargeBinding


class TestAdapter : ListAdapter<MovieListDomainModel, TestAdapter.MovieViewHolder>(MainDiffUtil()) {

    inner class MovieViewHolder(private val binding: ItemMovieLargeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieListDomainModel) {
            binding.movieInfo = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            ItemMovieLargeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        if (getItem(position) != null) holder.bind(getItem(position))
    }
}
