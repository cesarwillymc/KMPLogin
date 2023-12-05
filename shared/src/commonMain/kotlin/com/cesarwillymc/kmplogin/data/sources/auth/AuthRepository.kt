package com.cesarwillymc.kmplogin.data.sources.auth

import com.cesarwillymc.kmplogin.data.sources.auth.entities.AuthRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.ForgotEmailRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.ForgotPasswordRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.LogoutRequest
import com.cesarwillymc.kmplogin.data.sources.auth.entities.RefreshTokenRequest
import com.cesarwillymc.kmplogin.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.kmplogin.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.Auth
import com.cesarwillymc.kmplogin.util.state.Result
import com.cesarwillymc.kmplogin.util.state.dataOrNull
import com.cesarwillymc.kmplogin.util.state.isSuccess
import com.cesarwillymc.kmplogin.util.state.map
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class AuthRepository @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource,
    private val resultMapper: AuthResultMapper,
    private val sharedDao: PreferencesDao
) : AuthDataSource {
    override suspend fun signIn(email: String, password: String): Result<Auth> {
        return remoteDataSource.signIn(AuthRequest(email, password))
            .map(resultMapper::fromResponseToDomain).also {
                if (it.isSuccess) {
                    sharedDao.saveToken(it.dataOrNull()?.token.orEmpty())
                    sharedDao.saveRefreshToken(it.dataOrNull()?.refreshToken.orEmpty())
                    sharedDao.saveTokenType(it.dataOrNull()?.tokenType.orEmpty())
                }
            }
    }

    override suspend fun logout(): Result<Unit> {
        return remoteDataSource.logout(LogoutRequest(sharedDao.getToken.dataOrNull().orEmpty()))
            .also {
                if (it.isSuccess) {
                    sharedDao.cleanPreferences()
                }
            }
    }

    override suspend fun forgotPassword(email: String): Result<Unit> {
        return remoteDataSource.forgotPassword(ForgotPasswordRequest(ForgotEmailRequest(email)))
    }

    override suspend fun refreshToken(): Result<Auth> {
        return remoteDataSource.refreshToken(
            RefreshTokenRequest(
                sharedDao.getRefreshToken.dataOrNull().orEmpty()
            )
        ).map(resultMapper::fromResponseToDomain).also {
            if (it.isSuccess) {
                sharedDao.saveToken(it.dataOrNull()?.token.orEmpty())
                sharedDao.saveRefreshToken(it.dataOrNull()?.refreshToken.orEmpty())
                sharedDao.saveTokenType(it.dataOrNull()?.tokenType.orEmpty())
            }
        }
    }

    override suspend fun isLogged(): Result<Boolean> {
        return sharedDao.isLogged
    }
}
