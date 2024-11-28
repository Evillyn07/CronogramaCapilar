package com.amandarezende.cronogramacapilar

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CronoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}