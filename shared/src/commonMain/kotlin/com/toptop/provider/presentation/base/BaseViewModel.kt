package com.toptop.provider.presentation.base

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent

abstract class BaseViewModel<State, Event>(defaultState: State) : KMMViewModel(),
    KoinComponent {

    protected val stateData = MutableStateFlow(defaultState)

    @NativeCoroutinesState
    val state = stateData.asStateFlow()

    val currentState: State
        get() = state.value

    abstract fun onEvent(event: Event)
}