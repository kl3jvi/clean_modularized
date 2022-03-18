package com.kl3jvi.data_api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
//data class TmdbApiResponse(
//    @field:Json(name = "page")
//    val page: Int? = 0,
//    @field:Json(name = "total_results")
//    val totalResults: Int? = 0,
//    @field:Json(name = "total_pages")
//    val totalPages: Int? = 0,
//    @field:Json(name = "results")
//    var results: List<MovieListResponse>,
//)

@JsonClass(generateAdapter = true)
data class TmdbApiResponse(
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "results")
    var results: List<MovieListResponse>,
    @field:Json(name = "total_pages")
    val totalPages: Int,
    @field:Json(name = "total_results")
    val totalResults: Int
)