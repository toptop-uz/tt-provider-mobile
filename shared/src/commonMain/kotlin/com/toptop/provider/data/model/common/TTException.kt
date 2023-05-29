package com.toptop.provider.data.model.common

import io.ktor.http.HttpStatusCode

data class TTException(
    val message: String,
    val code: HttpStatusCode
)