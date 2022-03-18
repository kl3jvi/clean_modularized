package com.kl3jvi.data.di

import com.kl3jvi.data.mapper.MovieListResponseToDomainModelMapper
import com.kl3jvi.data.mapper.MovieListResponseToDomainModelMapperImpl
import com.kl3jvi.data.repository.MoviesRepositoryImpl
import com.kl3jvi.domain.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    single<MoviesRepository> { MoviesRepositoryImpl() }
    single<MovieListResponseToDomainModelMapper> { MovieListResponseToDomainModelMapperImpl() }
}