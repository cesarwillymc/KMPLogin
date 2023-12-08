package com.cesarwillymc.kmplogin.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 *
 * It can be used for use cases that return Unit, Boolean, Int, etc.
 * No mapper needed
 */
abstract class SuspendUseCase<in Params, out Results>(
    private val coroutineDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(parameters: Params): Result<Results> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters)
            }
        } catch (e: Exception) {
//            Log.e(LOG_DOMAIN, e.message.toString())
            Result.failure(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: Params): Result<Results>
}

suspend operator fun <Results> SuspendUseCase<Unit, Results>.invoke(): Result<Results> = this(Unit)
