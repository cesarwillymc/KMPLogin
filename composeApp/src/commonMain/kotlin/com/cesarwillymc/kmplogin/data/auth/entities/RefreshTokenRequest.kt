package com.cesarwillymc.kmplogin.data.auth.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Serializable
data class RefreshTokenRequest(
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("grant_type")
    val grantType: String = "refresh_token"
)
