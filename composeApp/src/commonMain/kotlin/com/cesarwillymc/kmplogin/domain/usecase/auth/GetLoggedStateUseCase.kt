package com.cesarwillymc.kmplogin.domain.usecase.auth

import com.cesarwillymc.kmplogin.data.sources.auth.AuthDataSource
import com.cesarwillymc.kmplogin.di.IoDispatcher
import com.cesarwillymc.kmplogin.domain.base.SuspendUseCase
import com.cesarwillymc.kmplogin.util.state.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class GetLoggedStateUseCase @Inject constructor(
    private val repository: AuthDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Boolean>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<Boolean> {
        return repository.isLogged()
    }
}
