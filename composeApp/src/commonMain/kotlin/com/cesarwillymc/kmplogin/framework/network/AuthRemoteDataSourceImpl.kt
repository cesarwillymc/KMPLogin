package com.cesarwillymc.kmplogin.framework.network

import com.cesarwillymc.kmplogin.framework.util.BaseRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.AuthResponse
import com.cesarwillymc.kmplogin.data.sources.auth.entities.ForgotPasswordRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.RefreshTokenRequest
import com.cesarwillymc.kmplogin.data.sources.auth.remote.AuthRemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRemoteDataSourceImpl (
    private val client: HttpClient
) : AuthRemoteDataSource,
    BaseRemoteDataSource() {
    override suspend fun signIn(authRequest: AuthRequest): Result<AuthResponse> = getResult {
        client.post{
            url(HttpRoutes.Auth.LOGIN)
            contentType(ContentType.Application.Json)
            setBody(authRequest)
        }.body()
    }

    override suspend fun logout(logoutRequest: LogoutRequest): Result<Unit> = getResult {
        client.post{
            url(HttpRoutes.Auth.LOGOUT)
            contentType(ContentType.Application.Json)
            setBody(logoutRequest)
        }.body()
    }

    override suspend fun forgotPassword(forgotPassword: ForgotPasswordRequest): Result<Unit> =
        getResult {
            client.post{
                url(HttpRoutes.Auth.FORGOT)
                contentType(ContentType.Application.Json)
                setBody(forgotPassword)
            }.body()
        }

    override suspend fun refreshToken(refresh: RefreshTokenRequest): Result<AuthResponse> =
        getResult {
            client.post{
                url(HttpRoutes.Auth.REFRESH)
                contentType(ContentType.Application.Json)
                setBody(refresh)
            }.body()
        }
}
