package com.toptop.provider.data.remote.response

import com.toptop.provider.data.model.common.AuthModel
import com.toptop.provider.data.util.DataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    @SerialName(value = "access_token")
    val accessToken: String? = null
) : DataMapper<AuthResponse, AuthModel> {

    override fun AuthResponse.mapToDomain(): AuthModel {
        return AuthModel(
            accessToken = accessToken.orEmpty()
        )
    }
}