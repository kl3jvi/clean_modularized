package com.kl3jvi.domain.model

import java.util.*

data class TmdbApiResponseDomain<T>(
    val page: Int? = 0,
    val totalResults: Int? = 0,
    val totalPages: Int? = 0,
    var results: List<T>? = null,
)

data class MovieListDomainModel(
    val id: String,
    val posterPath: String?,
    val title: String?,
    val releaseDate: Calendar?,
    var genreList: List<GenreDomainModel>?,
    val voteAverage: Float?,
    val voteCount: Int? = null,
    val backdropPath: String?,
    val genreIds: List<Int>?
)

data class GenreDomainModel(
    val id: Int,
    val name: String?
)