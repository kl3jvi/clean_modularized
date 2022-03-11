package com.kl3jvi.feature_favorites.presentation.favorites

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.feature_favorites.R
import com.kl3jvi.feature_favorites.databinding.FavoritesFragmentBinding
import com.kl3jvi.mvvm_template.common.viewBinding

class FavoritesFragment : Fragment(R.layout.favorites_fragment) {
    private val viewModel: FavoritesViewModel by viewModels()
    private val binding: FavoritesFragmentBinding by viewBinding()

}