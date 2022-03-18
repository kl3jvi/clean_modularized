package com.kl3jvi.feature_home.di

import com.kl3jvi.feature_home.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module { viewModel { (list: String) -> HomeViewModel(get(), list) } }