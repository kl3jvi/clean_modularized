package com.kl3jvi.data_api.data.remote

import com.kl3jvi.data.MoviesRemoteSource
import com.kl3jvi.data.model.GenreRepositoryModel
import com.kl3jvi.data.model.MovieListRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import com.kl3jvi.data_api.MovieService
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MoviesRemoteSourceImpl : MoviesRemoteSource, KoinComponent {
    val apiService: MovieService by inject()

    override suspend fun getGenreList(): Flow<GenreRepositoryModel> {
        TODO("Not yet implemented")
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