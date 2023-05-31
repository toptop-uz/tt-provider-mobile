package com.toptop.provider.data.remote.response

import com.toptop.provider.data.model.common.VerifyModel
import com.toptop.provider.data.util.DataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VerifyResponse(
    @SerialName(value = "access_token")
    val accessToken: String? = null
) : DataMapper<VerifyResponse, VerifyModel> {

    override fun VerifyResponse.mapToDomain(): VerifyModel {
        return VerifyModel(
            accessToken = accessToken.orEmpty()
        )
    }
}