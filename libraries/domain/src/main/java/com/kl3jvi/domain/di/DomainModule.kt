package com.kl3jvi.domain.di

import com.kl3jvi.domain.usecase.GetMoviesList
import com.kl3jvi.domain.usecase.GetMoviesListImpl
import org.koin.dsl.module

val domainModule = module {
    factory<GetMoviesList> { GetMoviesListImpl() }
}