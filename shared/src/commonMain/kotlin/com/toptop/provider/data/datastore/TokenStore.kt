package com.toptop.provider.data.datastore

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.set

class TokenStore(private val settings: ObservableSettings) {

    fun getAccessToken(): String {
        return settings.getString(Keys.ACCESS_TOKEN, "")
    }

    fun setAccessToken(accessToken: String?) {
        accessToken ?: return
        settings[Keys.ACCESS_TOKEN] = accessToken
    }

    fun clearAll() {
        settings.apply {
            set(Keys.ACCESS_TOKEN, "")
        }
    }
}