package com.kl3jvi.data_api.di

import com.kl3jvi.data_api.mapper.MovieListResponseToRepositoryModelMapperImpl
import org.koin.dsl.module

val apiModule = module {
    single { MovieListResponseToRepositoryModelMapperImpl() }


}