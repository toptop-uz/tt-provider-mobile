package com.toptop.provider.presentation.selectLanguage

import com.rickclephas.kmm.viewmodel.coroutineScope
import com.toptop.provider.data.datastore.AppStore
import com.toptop.provider.data.model.type.LanguageType
import com.toptop.provider.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SelectLanguageViewModel :
    BaseViewModel<SelectLanguageState, SelectLanguageEvent>(SelectLanguageState()), KoinComponent {

    private val appStore by inject<AppStore>()

    override fun onEvent(event: SelectLanguageEvent) {
        when (event) {
            is SelectLanguageEvent.SelectLanguage -> onSelectLanguage(event.value)
        }
    }

    private fun onSelectLanguage(language: LanguageType) {
        viewModelScope.coroutineScope.launch {
            appStore.setLanguage(language)

            stateData.update {
                it.copy(selectedLanguage = appStore.getLanguage())
            }
        }
    }
}