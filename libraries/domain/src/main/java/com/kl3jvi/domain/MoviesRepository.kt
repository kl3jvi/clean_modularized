package com.kl3jvi.domain

import com.kl3jvi.domain.model.GenreDomainModel
import com.kl3jvi.domain.model.MovieListDomainModel
import com.kl3jvi.domain.model.TmdbApiResponseDomain
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun getGenreList(): Flow<GenreDomainModel>

    suspend fun getMovieList(
        list: String,
        page: Int? = null
    ): Flow<TmdbApiResponseDomain<MovieListDomainModel>>

    suspend fun getMovieDetail(): Flow<TmdbApiResponseDomain<MovieListDomainModel>>
}
