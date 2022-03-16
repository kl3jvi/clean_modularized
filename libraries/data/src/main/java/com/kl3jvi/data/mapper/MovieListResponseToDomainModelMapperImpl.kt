package com.kl3jvi.data.mapper

import com.kl3jvi.data.model.MovieListRepositoryModel
import com.kl3jvi.data.model.TmdbApiResponseRepository
import com.kl3jvi.domain.model.GenreDomainModel
import com.kl3jvi.domain.model.MovieListDomainModel
import com.kl3jvi.domain.model.TmdbApiResponseDomain

interface MovieListResponseToDomainModelMapper {
    fun toDomainModel(tmdbApiResponse: TmdbApiResponseRepository<MovieListRepositoryModel>): TmdbApiResponseDomain<MovieListDomainModel>
}

class MovieListResponseToDomainModelMapperImpl : MovieListResponseToDomainModelMapper {
    override fun toDomainModel(
        tmdbApiResponse: TmdbApiResponseRepository<MovieListRepositoryModel>
    ): TmdbApiResponseDomain<MovieListDomainModel> {
        val movieListDomainModelList = tmdbApiResponse.results?.map {
            MovieListDomainModel(
                it.id,
                it.posterPath,
                it.title,
                it.releaseDate,
                it.genreList?.map {
                    GenreDomainModel(
                        it.id,
                        it.name
                    )
                },
                it.voteAverage,
                it.voteCount,
                it.backdropPath,
                it.genreIds
            )
        }

        return TmdbApiResponseDomain(
            tmdbApiResponse.page,
            tmdbApiResponse.totalResults,
            tmdbApiResponse.totalPages,
            movieListDomainModelList
        )
    }
}