package com.toptop.provider.data.datastore

import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.set
import com.toptop.provider.data.model.type.EntryType

class AppStore(private val settings: ObservableSettings) {

    fun isDarkMode(): Boolean {
        return settings.getBoolean(Keys.IS_DARK_MODE, false)
    }

    fun setDarkMode(isDarkMode: Boolean) {
        settings[Keys.IS_DARK_MODE] = isDarkMode
    }

    fun getEntryType(): EntryType {
        return EntryType.valueOf(settings.getString(Keys.ENTRY_TYPE, EntryType.AUTH.name))
    }

    fun setEntryType(entryType: EntryType) {
        settings[Keys.ENTRY_TYPE] = entryType.name
    }
}