package com.cesarwillymc.kmplogin.domain.repository

import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.Auth

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthRepository {
    suspend fun signIn(
        email: String,
        password: String
    ): Result<Auth>

    suspend fun logout(): Result<Unit>
    suspend fun forgotPassword(email: String): Result<Unit>

    suspend fun refreshToken(): Result<Auth>

    suspend fun isLogged(): Result<Boolean>
}
