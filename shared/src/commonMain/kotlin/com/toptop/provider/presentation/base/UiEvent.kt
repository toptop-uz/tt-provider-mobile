package com.toptop.provider.presentation.base

sealed interface UiEvent {
    data class ShowToast(val message: String) : UiEvent
}