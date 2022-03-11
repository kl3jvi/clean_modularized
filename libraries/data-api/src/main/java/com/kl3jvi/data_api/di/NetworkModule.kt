package com.kl3jvi.data_api.di

import com.kl3jvi.data_api.BuildConfig
import com.kl3jvi.data_api.MovieService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    fun getBaseUrl() = "https://api.themoviedb.org/3/"
    single { getBaseUrl() }

    single {
        OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(httpLoggingInterceptor)
            }
            connectTimeout(20, TimeUnit.SECONDS)
            readTimeout(20, TimeUnit.SECONDS)
            writeTimeout(20, TimeUnit.SECONDS)
        }.build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(getBaseUrl())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }


    single { single { get<Retrofit>().create(MovieService::class.java) } }

}

