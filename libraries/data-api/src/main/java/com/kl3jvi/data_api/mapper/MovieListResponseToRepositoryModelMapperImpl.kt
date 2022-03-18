package com.kl3jvi.data_api.mapper

import com.kl3jvi.data.model.GenreRepositoryModel
import com.kl3jvi.data.model.MovieListRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import com.kl3jvi.data_api.model.TmdbApiResponse

interface MovieListResponseToRepositoryModelMapper {
    fun toRepositoryModel(tmdbApiResponse: TmdbApiResponse): TmdbApiResponseRepository
}

class MovieListResponseToRepositoryModelMapperImpl : MovieListResponseToRepositoryModelMapper {
    override fun toRepositoryModel(
        tmdbApiResponse: TmdbApiResponse
    ): TmdbApiResponseRepository {
        val movieListModel = TmdbApiResponseRepository()

        movieListModel.results = tmdbApiResponse.results.map { movieListResponse ->
            MovieListRepositoryModel(
                movieListResponse.id,
                movieListResponse.posterPath,
                movieListResponse.title,
                movieListResponse.releaseDate,
                movieListResponse.genreList?.map { genre ->
                    GenreRepositoryModel(
                        genre.id,
                        genre.name
                    )
                },
                movieListResponse.voteAverage,
                movieListResponse.voteCount,
                movieListResponse.backdropPath,
                movieListResponse.genreIds,
            )
        }
        return movieListModel
    }
}