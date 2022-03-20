package com.kl3jvi.data

import com.kl3jvi.data.model.GenreRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import kotlinx.coroutines.flow.Flow

interface MoviesRemoteSource {
    suspend fun getGenreList(): Flow<GenreRepositoryModel>

    suspend fun getMovieList(
        list: String,
        page: Int? = null
    ): Flow<TmdbApiResponseRepository>

    suspend fun getMovieDetail(): Flow<TmdbApiResponseRepository>
}