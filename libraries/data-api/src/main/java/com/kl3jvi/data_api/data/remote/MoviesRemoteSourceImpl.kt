package com.kl3jvi.data_api.data.remote

import com.kl3jvi.data.MoviesRemoteSource
import com.kl3jvi.data.model.GenreRepositoryModel
import com.kl3jvi.data.model.MovieListRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import com.kl3jvi.data_api.MovieService
import com.kl3jvi.data_api.mapper.MovieListResponseToRepositoryModelMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.net.UnknownHostException

class MoviesRemoteSourceImpl : MoviesRemoteSource, KoinComponent {
    private val apiService: MovieService by inject()
    private val movieListMapper: MovieListResponseToRepositoryModelMapper by inject()
    private val _movieListSharedFlow = MutableStateFlow(getInitialMovieListInfoModel())
    private val movieListSharedFlow = _movieListSharedFlow.asSharedFlow()


    override suspend fun getGenreList(): Flow<GenreRepositoryModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieList(
        list: String,
        page: Int?
    ): Flow<TmdbApiResponseRepository<MovieListRepositoryModel>> {
        try {
            movieListMapper.toRepositoryModel(apiService.fetchMovieList(list, page))
                .let { _movieListSharedFlow.emit(it) }
        } catch (connectionException: UnknownHostException) {
            throw connectionException
        }
        return movieListSharedFlow.distinctUntilChanged()
    }

    override suspend fun getMovieDetail(): Flow<TmdbApiResponseRepository<MovieListRepositoryModel>> {
        TODO("Not yet implemented")
    }

    private fun getInitialMovieListInfoModel() =
        TmdbApiResponseRepository<MovieListRepositoryModel>(
            page = 0,
            totalResults = null,
            totalPages = null,
            results = emptyList()
        )
}