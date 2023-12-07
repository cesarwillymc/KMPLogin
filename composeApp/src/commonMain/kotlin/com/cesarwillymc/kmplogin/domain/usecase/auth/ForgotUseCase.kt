package com.cesarwillymc.kmplogin.domain.usecase.auth

import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.domain.base.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher
/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class ForgotUseCase (
    private val repository: AuthRepository,
     dispatcher: CoroutineDispatcher
) : SuspendUseCase<String, Unit>(
    dispatcher
) {
    override suspend fun execute(parameters: String): Result<Unit> {
        return repository.forgotPassword(parameters)
    }
}
