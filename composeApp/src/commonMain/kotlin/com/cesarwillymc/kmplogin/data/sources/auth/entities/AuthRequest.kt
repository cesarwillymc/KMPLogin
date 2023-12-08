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
data class AuthRequest(
    val email: String,
    val password: String,
    @SerialName("grant_type")
    val grantType: String = "password"
)
