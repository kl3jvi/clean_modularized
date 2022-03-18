package com.kl3jvi.mvvm_template.application

import android.app.Application
import com.kl3jvi.data.di.dataModule
import com.kl3jvi.data_api.di.apiModule
import com.kl3jvi.data_api.di.networkModule
import com.kl3jvi.domain.di.domainModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            modules(
                apiModule,
                networkModule,
                domainModule,
                dataModule,
            )
        }
    }
}