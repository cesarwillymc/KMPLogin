package com.cesarwillymc.kmplogin.data.sources.auth.entities

import kotlinx.serialization.Serializable

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Serializable
data class ForgotPasswordRequest(
    val user: ForgotEmailRequest
)
@Serializable
data class ForgotEmailRequest(
    val email: String
)
