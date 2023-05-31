package com.toptop.provider.presentation.auth.sendCode

import com.toptop.provider.data.model.common.TTException

data class SendCodeState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val exception: TTException? = null
)
