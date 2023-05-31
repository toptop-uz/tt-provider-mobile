package com.toptop.provider.data.remote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyRequest(
    @SerialName(value = "code")
    val code: String? = null
)