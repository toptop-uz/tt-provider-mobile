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

    fun getEntryType(): EntryType {
        return EntryType.valueOf(settings.getString(Keys.ENTRY_TYPE, EntryType.Auth.name))
    }

    fun setEntryType(entryType: EntryType) {
        settings[Keys.ENTRY_TYPE] = entryType.name
    }
}