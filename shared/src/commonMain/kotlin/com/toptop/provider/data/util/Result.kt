package com.toptop.provider.data.util

import com.toptop.provider.data.remote.util.ErrorHandler
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess

suspend inline fun <reified T> HttpResponse.bodyAsModel(): T? {
    return if (bodyAsText().isNotEmpty()) body<T>() else null
}

suspend inline fun <reified T : DataMapper<T, S>, S> HttpResponse.bodyAsMapModel(): S? {
    return if (bodyAsText().isNotEmpty()) body<T>().mapToDomain() else null
}

suspend inline fun <reified T> HttpResponse.bodyAsState(): UiState.Success<T> {
    return UiState.success(
        data = bodyAsModel(),
        statusCode = status
    )
}

suspend inline fun <reified T : DataMapper<T, S>, S> HttpResponse.bodyAsMapState(): UiState.Success<S> {
    return UiState.success(
        data = bodyAsMapModel<T, S>(),
        statusCode = status
    )
}

suspend infix fun HttpResponse.onSuccess(
    onSuccess: suspend HttpResponse.() -> Unit
): HttpResponse {
    if (status.isSuccess()) onSuccess(this)
    return this
}

suspend infix fun HttpResponse.onFailure(
    onFailure: suspend (HttpResponse, UiState.Failure) -> Unit
): HttpResponse {
    if (!status.isSuccess()) {
        onFailure(
            this,
            ErrorHandler.resolveMessage(
                message = bodyAsText(),
                code = status
            )
        )
    }
    return this
}