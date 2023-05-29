package com.toptop.provider.data.remote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(
    @SerialName(value = "phone")
    val phone: String? = null
)