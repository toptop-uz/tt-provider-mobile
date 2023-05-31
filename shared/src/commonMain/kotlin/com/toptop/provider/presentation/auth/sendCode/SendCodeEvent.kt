package com.toptop.provider.presentation.auth.sendCode

sealed class SendCodeEvent {
    object SendCode : SendCodeEvent()
}