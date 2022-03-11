package com.kl3jvi.data_api.data.remote

import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

const val YOUTUBE_THUMBNAIL_URL = "https://img.youtube.com/vi/"
const val YOUTUBE_VIDEO_URL = "https://www.youtube.com/watch?v="


@JsonClass(generateAdapter = true)
data class MovieListResponse(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: Calendar?,
    @field:Json(name = "genres")
    @ColumnInfo(name = "genres")
    var genreList: List<Genre>?,
    @field:Json(name = "vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Float?,
    @field:Json(name = "vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int? = null,
    @field:Json(name = "backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @Ignore
    @field:Json(name = "genre_ids")
    val genreIds: List<Int>?
)

data class MovieDetailResponse(
    @field:Json(name = "id")
    val id: String,
    @field:Json(name = "poster_path")
    val posterPath: String?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "vote_average")
    val voteAverage: Float?,
    @field:Json(name = "vote_count")
    val voteCount: Int?,
    @field:Json(name = "overview")
    val overview: String?,
    @field:Json(name = "release_date")
    val releaseDate: Calendar?,
    @field:Json(name = "genres")
    val genreList: List<Genre>?,
    @field:Json(name = "runtime")
    val runtime: Int?,
    @field:Json(name = "backdrop_path")
    val backdropPath: String?,
)

data class GenreListing(
    @field:Json(name = "genres")
    val genreList: List<Genre>?
)

data class Genre(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String?
)

data class Video(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "key") val key: String?

    // TODO: store `site` and provide different thumbnail
) {
    enum class ThumbnailSize(val path: String) {
        MAX("maxres"),
        MQ("mq"),
        HD("hq"),
        SD("sd"),
        MIN("");

        override fun toString() = path
    }

    val youtubeThumbnail get() = "${YOUTUBE_THUMBNAIL_URL}$key/${ThumbnailSize.MQ}default.jpg"
    val youtubeVideo get() = "${YOUTUBE_VIDEO_URL}$key"
}

data class Review(
    @field:Json(name = "id")
    val id: String?,
    @field:Json(name = "author_details")
    val author: Author?,
    @field:Json(name = "content")
    val content: String?,
    @field:Json(name = "created_at")
    val createdAt: Calendar?
) {
    data class Author(
        @field:Json(name = "username")
        val username: String?,
        @field:Json(name = "avatar_path")
        val avatarPath: String?,
        @field:Json(name = "rating")
        val rating: Float?
    ) {
        fun getAvatarFullPath(): String {
            return if (avatarPath?.startsWith("/http", ignoreCase = true) == true) {
                avatarPath.replaceFirst("/", "")
            } else {
                ImageApi.getFullUrl(avatarPath, ImageSize.W185)
            }
        }
    }
}

data class CastListing(
    @field:Json(name = "cast")
    val castList: List<Cast>?
) {
    data class Cast(
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val actorName: String?,
        @field:Json(name = "character")
        val character: String?,
        @field:Json(name = "profile_path")
        val profilePath: String
    ) {
        fun getAvatarFullPath() = ImageApi.getFullUrl(profilePath, ImageSize.W185)
    }
}
