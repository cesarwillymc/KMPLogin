package com.cesarwillymc.kmplogin.domain.usecase.auth

import com.cesarwillymc.kmplogin.domain.base.SuspendUseCase
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.Auth
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.AuthParams
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SignInUseCase (
    private val repository: AuthRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<AuthParams, Auth>(
    dispatcher
) {
    override suspend fun execute(parameters: AuthParams): Result<Auth> {
        return repository.signIn(email = parameters.email, password = parameters.password)
    }
}
