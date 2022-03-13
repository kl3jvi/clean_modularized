package com.kl3jvi.data_api.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("api_key", TMDB_API_KEY).build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

    companion object {
        const val TMDB_API_KEY = "0d04980a9a7acd4015f8b846694d948f"
    }
}

