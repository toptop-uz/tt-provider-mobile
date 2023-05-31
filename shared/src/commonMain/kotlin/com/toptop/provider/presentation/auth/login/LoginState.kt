package com.toptop.provider.presentation.auth.login

import com.toptop.provider.data.model.common.TTException

data class LoginState(
    val phone: String = "",
    val isTermsChecked: Boolean = false,
    val isEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val exception: TTException? = null
)
