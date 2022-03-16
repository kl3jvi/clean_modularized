package com.kl3jvi.data.repository

import com.kl3jvi.data.MoviesRemoteSource
import com.kl3jvi.data.mapper.MovieListResponseToDomainModelMapper
import com.kl3jvi.domain.MoviesRepository
import com.kl3jvi.domain.model.GenreDomainModel
import com.kl3jvi.domain.model.MovieListDomainModel
import com.kl3jvi.domain.model.TmdbApiResponseDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.supervisorScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MovieRepositoryImpl : MoviesRepository, KoinComponent {

    private val moviesRemoteSource: MoviesRemoteSource by inject()
    private val movieListDomainMapper: MovieListResponseToDomainModelMapper by inject()

    override suspend fun getGenreList(): Flow<GenreDomainModel> = supervisorScope {
        TODO("Not yet implemented")

    }

    override suspend fun getMovieList(
        list: String,
        page: Int?
    ): Flow<TmdbApiResponseDomain<MovieListDomainModel>> = supervisorScope {
        moviesRemoteSource.getMovieList(list, page).map { movieListRepositoryModel ->
            movieListDomainMapper.toDomainModel(movieListRepositoryModel)
        }
    }

    override suspend fun getMovieDetail(): Flow<TmdbApiResponseDomain<MovieListDomainModel>> {
        TODO("Not yet implemented")
    }

}