package com.cesarwillymc.kmplogin.data.auth.remote

import com.cesarwillymc.kmplogin.data.auth.entities.AuthRequest
import com.cesarwillymc.kmplogin.data.auth.entities.AuthResponse
import com.cesarwillymc.kmplogin.data.auth.entities.ForgotPasswordRequest
import com.cesarwillymc.kmplogin.data.auth.entities.LogoutRequest
import com.cesarwillymc.kmplogin.data.auth.entities.RefreshTokenRequest

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface AuthRemoteDataSource {
    suspend fun signIn(
        authRequest: AuthRequest
    ): Result<AuthResponse>

    suspend fun logout(
        logoutRequest: LogoutRequest
    ): Result<Unit>

    suspend fun forgotPassword(
        forgotPassword: ForgotPasswordRequest
    ): Result<Unit>

    suspend fun refreshToken(
        refresh: RefreshTokenRequest
    ): Result<AuthResponse>
}
