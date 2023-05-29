package com.toptop.provider.android.app

import android.app.Application
import com.toptop.provider.di.initKoin
import org.koin.android.ext.koin.androidContext

class TTApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@TTApp)
        }
    }
}