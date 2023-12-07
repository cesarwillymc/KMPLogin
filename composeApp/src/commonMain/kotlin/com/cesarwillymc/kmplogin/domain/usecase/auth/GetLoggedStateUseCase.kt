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
class GetLoggedStateUseCase (
    private val repository: AuthRepository,
     dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Boolean>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<Boolean> {
        return repository.isLogged()
    }
}
