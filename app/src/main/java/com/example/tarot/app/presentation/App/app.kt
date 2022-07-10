package com.example.tarot.app.presentation.App

import android.app.Application
import com.example.tarot.app.di.appModule
import com.example.tarot.app.di.dataModule
import com.example.tarot.app.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class app:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@app)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}