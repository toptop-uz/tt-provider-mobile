package com.toptop.provider.data.datastore

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.set
import com.toptop.provider.data.model.type.EntryType
import com.toptop.provider.data.model.type.LanguageType

class AppStore(private val settings: ObservableSettings) {

    fun getLanguage(): LanguageType {
        return try {
            val language = settings.getString(Keys.SELECTED_LANGUAGE, LanguageType.Uzbek.name)
            LanguageType.valueOf(language)
        } catch (_: Throwable) {
            LanguageType.Uzbek
        }
    }

    fun setLanguage(language: LanguageType) {
        settings[Keys.SELECTED_LANGUAGE] = language.name
    }

    fun getEntry(): EntryType {
        return try {
            val entry = settings.getString(Keys.ENTRY, EntryType.Auth.name)
            EntryType.valueOf(entry)
        } catch (_: Throwable) {
            EntryType.Auth
        }
    }

    fun setEntry(entryType: EntryType) {
        settings[Keys.ENTRY] = entryType.name
    }
}