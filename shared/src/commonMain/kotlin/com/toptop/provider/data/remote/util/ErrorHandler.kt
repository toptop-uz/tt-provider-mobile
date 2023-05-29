package com.toptop.provider.data.remote.util

import com.toptop.provider.data.model.common.TTException
import com.toptop.provider.data.util.UiState
import io.ktor.http.HttpStatusCode

object ErrorHandler {

    fun resolveException(throwable: Throwable? = null): UiState.Failure {
        return UiState.failure(
            TTException(
                message = throwable?.message.orEmpty(),
                code = HttpStatusCode.NotFound
            )
        )
    }

    fun resolveMessage(
        message: String? = null,
        code: HttpStatusCode? = null
    ): UiState.Failure {
        return UiState.failure(
            TTException(
                message = message.orEmpty(),
                code = code ?: HttpStatusCode.NotFound
            )
        )
    }
}