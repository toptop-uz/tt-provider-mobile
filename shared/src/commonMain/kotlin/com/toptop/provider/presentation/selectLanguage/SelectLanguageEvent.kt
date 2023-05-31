package com.toptop.provider.presentation.selectLanguage

import com.toptop.provider.data.model.type.LanguageType

sealed class SelectLanguageEvent {
    data class SelectLanguage(val value: LanguageType) : SelectLanguageEvent()
}