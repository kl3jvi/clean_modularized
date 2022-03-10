package com.kl3jvi.feature_home.presentation.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.feature_home.R
import com.kl3jvi.feature_home.databinding.DetailsFragmentBinding
import com.kl3jvi.mvvm_template.common.viewBinding

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private val viewModel: DetailsViewModel by viewModels()
    private val binding: DetailsFragmentBinding by viewBinding()


}