package com.toptop.provider.di

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.ObservableSettings
import com.toptop.provider.shared.DeviceInfo
import com.toptop.provider.shared.configureKtor
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual fun platformModule() = module {
    single { DeviceInfo() }
    single { createSettings() }
    single {
        HttpClient(Darwin) {
            configureKtor(
                tokenStore = get(),
                deviceInfo = get()
            )
        }
    }
//    single { AppDatabase(NativeSqliteDriver(AppDatabase.Schema, Constants.APP_DATABASE)) }
}

fun createSettings(): ObservableSettings {
    val delegate = NSUserDefaults.standardUserDefaults
    return NSUserDefaultsSettings(delegate = delegate)
}