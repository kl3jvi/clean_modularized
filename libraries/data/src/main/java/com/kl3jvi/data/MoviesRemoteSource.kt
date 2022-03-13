package com.kl3jvi.data

import com.kl3jvi.data_api.data.remote.GenreListing
import com.kl3jvi.data_api.data.remote.MovieListResponse
import com.kl3jvi.data_api.data.remote.TmdbApiResponse
import kotlinx.coroutines.flow.Flow

interface MoviesRemoteSource {
    suspend fun getGenreList(): Flow<GenreListing>
    suspend fun getMovieList(
        list: String,
        page: Int? = null
    ): Flow<TmdbApiResponse<MovieListResponse>>

    suspend fun getMovieDetail(): Flow<TmdbApiResponse<MovieListResponse>>
}