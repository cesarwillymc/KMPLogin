package com.cesarwillymc.kmplogin.data.sources.auth.remote

import com.cesarwillymc.kmplogin.data.settings.network.util.BaseRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.kmplogin.data.sources.auth.entities.ForgotPasswordRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.RefreshTokenRequest
import com.cesarwillymc.kmplogin.data.sources.auth.service.AuthService

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRemoteDataSourceImpl (
    private val authService: AuthService
) : AuthRemoteDataSource,
    BaseRemoteDataSource() {
    override suspend fun signIn(authRequest: AuthRequest): Result<AuthResponse> = getResult {
        authService.signIn(authRequest)
    }

    override suspend fun logout(logoutRequest: LogoutRequest): Result<Unit> = getResult {
        authService.logout(logoutRequest)
    }

    override suspend fun forgotPassword(forgotPassword: ForgotPasswordRequest): Result<Unit> =
        getResult {
            authService.forgotPassword(forgotPassword)
        }

    override suspend fun refreshToken(refresh: RefreshTokenRequest): Result<AuthResponse> =
        getResult {
            authService.refreshToken(refresh)
        }
}
