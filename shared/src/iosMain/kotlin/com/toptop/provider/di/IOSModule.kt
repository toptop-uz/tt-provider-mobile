package com.toptop.provider.di

import com.toptop.provider.data.datastore.AppStore
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IOSModule : KoinComponent {
    val appStore: AppStore by inject()

    fun initKoin() = initKoin {}
}