package com.kl3jvi.domain.usecase

import com.kl3jvi.domain.MoviesRepository
import com.kl3jvi.domain.model.MovieListDomainModel
import com.kl3jvi.domain.model.TmdbApiResponseDomain
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface GetMoviesList : KoinComponent {
    val moviesRepository: MoviesRepository
    suspend fun execute(
        list: String,
        page: Int? = null
    ): Flow<TmdbApiResponseDomain>
}

class GetMoviesListImpl : GetMoviesList {
    override val moviesRepository: MoviesRepository by inject();

    /**
     * You can use also operator fun invoke() {} , but i prefer abstraction over the use case for
     * further scalability
     */
    override suspend fun execute(
        list: String,
        page: Int?
    ): Flow<TmdbApiResponseDomain> =
        moviesRepository.getMovieList(list, page)
}