package com.kl3jvi.data.model

import com.kl3jvi.data_api.data.remote.Genre
import java.util.*

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