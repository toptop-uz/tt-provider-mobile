package com.toptop.provider.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.SharedPreferencesSettings
import com.toptop.provider.data.datastore.Keys
import com.toptop.provider.shared.DeviceInfo
import com.toptop.provider.shared.configureKtor
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module

actual fun platformModule() = module {
    single { DeviceInfo(get()) }
    single { createSettings(get()) }
    single {
        HttpClient(OkHttp) {
            configureKtor(
                tokenStore = get(),
                deviceInfo = get()
            )

            engine {
                addInterceptor(configureChuckerInterceptor(get()))
            }
        }
    }
//    single { AppDatabase(AndroidSqliteDriver(AppDatabase.Schema, get(), Constants.APP_DATABASE)) }
}

fun createSettings(context: Context): ObservableSettings {
    val delegate = context.getSharedPreferences(Keys.SHARED_PREFS_NAME, Context.MODE_PRIVATE)
    return SharedPreferencesSettings(delegate = delegate)
}

fun configureChuckerInterceptor(context: Context): ChuckerInterceptor {
    val chuckerCollector = ChuckerCollector(
        context = context,
        showNotification = true,
        retentionPeriod = RetentionManager.Period.ONE_HOUR
    )

    return ChuckerInterceptor.Builder(context)
        .collector(chuckerCollector)
        .maxContentLength(10_000L)
        .alwaysReadResponseBody(true)
        .build()
}