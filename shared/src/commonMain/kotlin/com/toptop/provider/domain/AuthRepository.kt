package com.toptop.provider.domain

import com.toptop.provider.data.datastore.TokenStore
import com.toptop.provider.data.model.common.AuthModel
import com.toptop.provider.data.remote.request.LoginRequest
import com.toptop.provider.data.remote.response.LoginResponse
import com.toptop.provider.data.remote.util.ErrorHandler
import com.toptop.provider.data.remote.util.HttpRoutes
import com.toptop.provider.data.util.UiState
import com.toptop.provider.data.util.bodyAsMapModel
import com.toptop.provider.data.util.onFailure
import com.toptop.provider.data.util.onSuccess
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AuthRepository : KoinComponent {

    private val client by inject<HttpClient>()
    private val tokenStore by inject<TokenStore>()

    suspend fun login(request: LoginRequest): Flow<UiState<Boolean>> {
        return flow {
            client.post {
                url(HttpRoutes.login)
                contentType(ContentType.Application.Json)
                setBody(request)
            } onSuccess {
                val model = bodyAsMapModel<LoginResponse, AuthModel>()

                if (model != null) {
                    tokenStore.setAccessToken(model.accessToken)

                    emit(UiState.success(true))
                } else {
                    emit(ErrorHandler.resolveMessage())
                }
            } onFailure { _, state ->
                emit(state)
            }
        }.catch { exception ->
            emit(ErrorHandler.resolveException(exception))
        }
    }
}