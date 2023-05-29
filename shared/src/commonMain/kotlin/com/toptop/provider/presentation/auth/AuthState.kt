package com.toptop.provider.presentation.auth

import com.toptop.provider.data.model.common.TTException

data class AuthState(
    val phone: String = "",
    val isTermsChecked: Boolean = false,
    val isEnabled: Boolean = false,
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val exception: TTException? = null
)
