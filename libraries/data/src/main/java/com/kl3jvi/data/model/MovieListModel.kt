package com.kl3jvi.data.model

import java.util.*

data class TmdbApiResponseRepository<T>(
    val page: Int? = 0,
    val totalResults: Int? = 0,
    val totalPages: Int? = 0,
    var results: List<T>? = null,
)

data class MovieListRepositoryModel(
    val id: String,
    val posterPath: String?,
    val title: String?,
    val releaseDate: Calendar?,
    var genreList: List<GenreRepositoryModel>?,
    val voteAverage: Float?,
    val voteCount: Int? = null,
    val backdropPath: String?,
    val genreIds: List<Int>?
)

data class GenreRepositoryModel(
    val id: Int,
    val name: String?
)