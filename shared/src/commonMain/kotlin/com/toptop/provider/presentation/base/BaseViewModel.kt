package com.toptop.provider.presentation.base

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

abstract class BaseViewModel<State, Event>(defaultState: State) : KMMViewModel(),
    KoinComponent {

    protected val stateData = MutableStateFlow(defaultState)

    @NativeCoroutinesState
    val state = stateData.asStateFlow()

    private val eventChannelData = Channel<UiEvent>()
    val eventChannel = eventChannelData.receiveAsFlow()

    val currentState: State
        get() = state.value

    abstract fun onEvent(event: Event)

    fun sendEvent(event: UiEvent) {
        viewModelScope.coroutineScope.launch {
            eventChannelData.send(event)
        }
    }
}