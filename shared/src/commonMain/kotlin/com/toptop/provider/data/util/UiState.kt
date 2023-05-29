package com.toptop.provider.data.util

import com.toptop.provider.data.model.common.TTException
import io.ktor.http.HttpStatusCode

sealed class UiState<out T> where T : Any? {
    data class Success<T>(
        val data: T? = null,
        val statusCode: HttpStatusCode
    ) : UiState<T>()

    data class Failure(val exception: TTException) : UiState<Nothing>()

    companion object {
        fun <T> success(
            data: T? = null,
            statusCode: HttpStatusCode = HttpStatusCode.OK
        ): Success<T> = Success(data, statusCode)

        fun failure(exception: TTException) = Failure(exception)
    }
}

infix fun <T> UiState<T>.onSuccess(onSuccess: UiState.Success<T>.() -> Unit): UiState<T> {
    return when (this) {
        is UiState.Success -> {
            onSuccess(this)
            this
        }

        else -> this
    }
}

infix fun <T> UiState<T>.onFailure(onFailure: UiState.Failure.() -> Unit): UiState<T> {
    return when (this) {
        is UiState.Failure -> {
            onFailure(this)
            this
        }

        else -> this
    }
}