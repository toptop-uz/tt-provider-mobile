package com.toptop.provider.shared

import com.toptop.provider.core.helpers.Constants
import com.toptop.provider.data.datastore.TokenStore
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

fun HttpClientConfig<*>.configureKtor(
    tokenStore: TokenStore,
    deviceInfo: DeviceInfo
) {
    install(HttpTimeout) {
        requestTimeoutMillis = 2 * 60 * 1000L
        connectTimeoutMillis = 2 * 60 * 1000L
        socketTimeoutMillis = 2 * 60 * 1000L
    }
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true
        })
    }
    install(Logging) {
        logger = DebugKtorLogger()
        level = LogLevel.INFO
    }

    defaultRequest {
        header("App-Version", Constants.APP_VERSION)
        header("Device-Version", deviceInfo.getDeviceInfo())
        header("Device-ID", deviceInfo.getDeviceUniqueId())
    }

    install(Auth) {
        bearer {
            loadTokens {
                BearerTokens(
                    accessToken = tokenStore.getAccessToken(),
                    refreshToken = tokenStore.getAccessToken()
                )
            }
            refreshTokens {
                EventChannel.sendEvent(Event.UNAUTHORIZED)

                BearerTokens(
                    accessToken = tokenStore.getAccessToken(),
                    refreshToken = tokenStore.getAccessToken()
                )
            }
        }
    }
}

class DebugKtorLogger : Logger {
    override fun log(message: String) {
    }
}