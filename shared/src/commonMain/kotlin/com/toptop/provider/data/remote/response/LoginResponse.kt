package com.toptop.provider.data.remote.response

import com.toptop.provider.data.model.common.AuthModel
import com.toptop.provider.data.util.DataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    @SerialName(value = "access_token")
    val accessToken: String? = null
) : DataMapper<LoginResponse, AuthModel> {

    override fun LoginResponse.mapToDomain(): AuthModel {
        return AuthModel(
            accessToken = accessToken.orEmpty()
        )
    }
}