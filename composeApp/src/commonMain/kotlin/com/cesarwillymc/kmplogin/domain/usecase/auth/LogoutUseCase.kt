package com.cesarwillymc.kmplogin.domain.usecase.auth

import com.cesarwillymc.kmplogin.domain.base.SuspendUseCase
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class LogoutUseCase  (
    private val repository: AuthRepository,
     dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Unit>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<Unit> {
        return repository.logout()
    }
}
