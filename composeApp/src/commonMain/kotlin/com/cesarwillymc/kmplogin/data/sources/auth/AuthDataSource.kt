package com.cesarwillymc.kmplogin.data.sources.auth

import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.Auth
import com.cesarwillymc.kmplogin.util.state.Result

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthDataSource {
    suspend fun signIn(
        email: String,
        password: String
    ): Result<Auth>

    suspend fun logout(): Result<Unit>
    suspend fun forgotPassword(email: String): Result<Unit>

    suspend fun refreshToken(): Result<Auth>

    suspend fun isLogged(): Result<Boolean>
}
