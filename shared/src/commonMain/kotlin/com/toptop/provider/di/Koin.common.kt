package com.toptop.provider.di

import com.toptop.provider.data.datastore.AppStore
import com.toptop.provider.domain.AuthRepository
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            storeModule(),
            databaseModule(),
            repositoryModule(),
            platformModule()
        )
    }

fun storeModule() = module {
    singleOf(::AppStore)
}

fun databaseModule() = module {
}

fun repositoryModule() = module {
    singleOf(::AuthRepository)
}

fun reloadKoinModules() {
    unloadKoinModules(
        listOf(
            storeModule(),
            databaseModule(),
            repositoryModule(),
            platformModule()
        )
    )
    loadKoinModules(
        listOf(
            storeModule(),
            databaseModule(),
            repositoryModule(),
            platformModule()
        )
    )
}