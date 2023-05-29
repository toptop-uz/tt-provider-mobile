package com.toptop.provider.presentation.auth

sealed class AuthEvent {
    data class ChangePhone(val value: String) : AuthEvent()
    data class ChangeTerms(val isChecked: Boolean) : AuthEvent()

    object Auth : AuthEvent()
}