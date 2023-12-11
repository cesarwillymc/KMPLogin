package com.cesarwillymc.kmplogin.framework.util

import com.cesarwillymc.kmplogin.util.constants.LOG_DOMAIN
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

//    override fun getError(throwable: Throwable): ErrorSource = when (throwable) {
//        is IOException -> ErrorSource.Network
//        is HttpException -> getErrorFromBody(throwable.response()?.errorBody(), throwable.code())
//        else -> ErrorSource.Unknown
//    }

//    private fun getErrorFromBody(errorBody: ResponseBody?, code: Int): ErrorSource {
//        return errorBody?.let {
//            try {
//                val errorApi = Gson().fromJson(it.string(), ErrorApi::class.java)
//                ErrorSource.ServiceError(
//                    errorCode = code.toString(),
//                    errorMessage = errorApi.error
//                )
//            } catch (jsonException: JsonSyntaxException) {
//                ErrorSource.Unknown
//            }
//        } ?: ErrorSource.Unknown
//    }
}
