package com.cesarwillymc.kmplogin.data.sources.auth.mapper

import com.cesarwillymc.kmplogin.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.Auth

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthResultMapperImpl : AuthResultMapper {
    override fun fromResponseToDomain(info: AuthResponse): Auth {
        return Auth(
            token = info.tokenData.attributes.accessToken,
            tokenType = info.tokenData.attributes.tokenType,
            refreshToken = info.tokenData.attributes.refreshToken
        )
    }
}
