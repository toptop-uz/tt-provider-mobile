package com.toptop.provider.data.remote.util

object HttpRoutes {
    private const val API_URL = "https://example.uz/api"

    private val getApiUrl
        get() = API_URL

    val login
        get() = "$getApiUrl/auth"
}