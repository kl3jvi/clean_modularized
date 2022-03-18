package com.kl3jvi.feature_home.presentation.home

import android.os.Bundle
import android.util.Log.e
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.kl3jvi.feature_home.R
import com.kl3jvi.feature_home.common.viewBinding
import com.kl3jvi.feature_home.databinding.HomeFragmentBinding
import com.kl3jvi.feature_home.di.viewModelModule
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.parameter.parametersOf


class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(
            module = viewModelModule
        )
    }

    private val viewModels: HomeViewModel by viewModel {
        parametersOf("popular")
    }
    private val binding: HomeFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModels.moviesListStateFlow.collect { state ->
                when (state) {
                    is State.Error -> {
                        logError("Error ${state.message}")
                    }
                    is State.Loading -> {
                        logError("Loading $state")
                    }
                    is State.Success -> {
                        logError(state.data.toString())
                    }
                }

            }
        }
    }
}

private fun logError(message: String) {
    e("HOME", message)
}