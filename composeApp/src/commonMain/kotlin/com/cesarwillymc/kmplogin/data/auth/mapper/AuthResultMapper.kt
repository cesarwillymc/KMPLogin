package com.cesarwillymc.kmplogin.data.auth.mapper

import com.cesarwillymc.kmplogin.data.auth.entities.AuthResponse
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.Auth

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthResultMapper {
    fun fromResponseToDomain(info: AuthResponse): Auth
}
