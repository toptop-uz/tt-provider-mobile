package com.toptop.provider.presentation.auth.login

sealed class LoginEvent {
    data class ChangePhone(val value: String) : LoginEvent()
    object ToggleTerms : LoginEvent()

    object Login : LoginEvent()
    object Idle : LoginEvent()
}