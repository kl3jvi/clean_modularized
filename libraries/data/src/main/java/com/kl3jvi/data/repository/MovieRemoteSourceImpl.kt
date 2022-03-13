package com.kl3jvi.data.repository

import com.kl3jvi.data.MoviesRemoteSource
import com.kl3jvi.data_api.data.remote.GenreListing
import com.kl3jvi.data_api.data.remote.MovieListResponse
import com.kl3jvi.data_api.data.remote.TmdbApiResponse
import kotlinx.coroutines.flow.Flow

class MovieRemoteSourceImpl : MoviesRemoteSource {
    override suspend fun getGenreList(): Flow<GenreListing> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieList(
        list: String,
        page: Int?
    ): Flow<TmdbApiResponse<MovieListResponse>> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieDetail(): Flow<TmdbApiResponse<MovieListResponse>> {
        TODO("Not yet implemented")
    }
}