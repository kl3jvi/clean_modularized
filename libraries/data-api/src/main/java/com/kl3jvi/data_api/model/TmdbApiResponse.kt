package com.kl3jvi.data_api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TmdbApiResponse<T>(
    @field:Json(name = "page")
    val page: Int? = 0,
    @field:Json(name = "total_results")
    val totalResults: Int? = 0,
    @field:Json(name = "total_pages")
    val totalPages: Int? = 0,
    @field:Json(name = "results")
    var results: List<T>? = null,
)