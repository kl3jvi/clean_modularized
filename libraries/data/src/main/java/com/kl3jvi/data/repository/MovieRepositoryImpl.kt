package com.kl3jvi.data.repository

import com.kl3jvi.data.MoviesRemoteSource
import com.kl3jvi.data.model.GenreRepositoryModel
import com.kl3jvi.data.model.MovieListRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieRepositoryImpl : MoviesRemoteSource, KoinComponent {

    private val moviesRemoteSource: MoviesRemoteSource by inject()


    override suspend fun getGenreList(): Flow<GenreRepositoryModel> = supervisorScope {
        moviesRemoteSource.getGenreList()
    }

    override suspend fun getMovieList(
        list: String,
        page: Int?
    ): Flow<TmdbApiResponseRepository<MovieListRepositoryModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetail(): Flow<TmdbApiResponseRepository<MovieListRepositoryModel>> {
        TODO("Not yet implemented")
    }
}