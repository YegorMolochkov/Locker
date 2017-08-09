package com.yegor.locker.lock

import android.app.Application

/**
 * Object represents application
 */
class ApplicationSingleton : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: ApplicationSingleton
            private set
    }
}