package com.cesarwillymc.kmplogin.data.util

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
abstract class BaseRemoteDataSource {

    protected suspend fun <Out> getResult(
        call: suspend () -> Out
    ): Result<Out> = try {
        Result.success(call())
    } catch (e: RedirectResponseException) {
        Result.failure(exception = (e))
    } catch (e: ClientRequestException) {
        Result.failure(exception = (e))
    } catch (e: ServerResponseException) {
        Result.failure(exception = e)
    } catch (e: Exception) {
        Result.failure(exception = e)
    }
}
