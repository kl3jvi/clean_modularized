package com.kl3jvi.feature_home.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.feature_home.R
import com.kl3jvi.feature_home.databinding.HomeFragmentBinding
import com.kl3jvi.mvvm_template.common.viewBinding


class HomeFragment : Fragment(R.layout.home_fragment) {
    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()

}