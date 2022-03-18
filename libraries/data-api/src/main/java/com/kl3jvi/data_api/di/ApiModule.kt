package com.kl3jvi.data_api.di

import com.kl3jvi.data.MoviesRemoteSource
import com.kl3jvi.data_api.data.remote.MoviesRemoteSourceImpl
import com.kl3jvi.data_api.mapper.MovieListResponseToRepositoryModelMapper
import com.kl3jvi.data_api.mapper.MovieListResponseToRepositoryModelMapperImpl
import org.koin.dsl.module

val apiModule = module {

    single<MoviesRemoteSource> { MoviesRemoteSourceImpl() }

    single<MovieListResponseToRepositoryModelMapper> {
        MovieListResponseToRepositoryModelMapperImpl()
    }

}