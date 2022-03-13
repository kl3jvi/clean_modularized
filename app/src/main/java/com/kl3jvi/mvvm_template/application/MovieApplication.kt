package com.kl3jvi.mvvm_template.application

import android.app.Application
import com.kl3jvi.data_api.di.apiModule
import com.kl3jvi.data_api.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            modules(
                apiModule,
                networkModule
            )
        }
    }
}