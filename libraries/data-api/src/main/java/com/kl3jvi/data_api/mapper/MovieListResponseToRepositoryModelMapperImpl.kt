package com.kl3jvi.data_api.mapper

import com.kl3jvi.data.model.GenreRepositoryModel
import com.kl3jvi.data.model.MovieListRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import com.kl3jvi.data_api.model.MovieListResponse
import com.kl3jvi.data_api.model.TmdbApiResponse

interface MovieListResponseToRepositoryModelMapper {
    fun toRepositoryModel(tmdbApiResponse: TmdbApiResponse<MovieListResponse>): TmdbApiResponseRepository<MovieListRepositoryModel>
}

class MovieListResponseToRepositoryModelMapperImpl : MovieListResponseToRepositoryModelMapper {
    override fun toRepositoryModel(
        tmdbApiResponse: TmdbApiResponse<MovieListResponse>
    ): TmdbApiResponseRepository<MovieListRepositoryModel> {
        val movieListModel = TmdbApiResponseRepository<MovieListRepositoryModel>()

        movieListModel.results = tmdbApiResponse.results?.map { movieListResponse ->
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