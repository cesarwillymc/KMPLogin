package com.cesarwillymc.kmplogin.data.sources.auth.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Cesar Canaza on 10/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Serializable
data class AuthResponse(
    @SerialName("data")
    val tokenData: TokenData
)
@Serializable
data class TokenData(
    val id: String,
    val type: String,
    val attributes: TokenAttributes
)
@Serializable
data class TokenAttributes(
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("token_type")
    val tokenType: String,
    @SerialName("expires_in")
    val expiresIn: Int,
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("created_at")
    val createdAt: Long
)
