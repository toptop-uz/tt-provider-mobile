package com.toptop.provider.presentation.auth.sendCode

sealed class SendCodeEvent {
    data class ChangeCode(val value: String) : SendCodeEvent()

    object ResendCode : SendCodeEvent()
    object Idle : SendCodeEvent()
}

sealed class SendCodeType {
    object ResendCode : SendCodeType()
    object Timer : SendCodeType()
}