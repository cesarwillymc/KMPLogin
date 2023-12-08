package com.cesarwillymc.kmplogin.data.sources.auth.entities

import kotlinx.serialization.Serializable

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Serializable
data class LogoutRequest(
    val token: String
)
