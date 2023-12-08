package com.cesarwillymc.kmplogin.framework.network

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.util.extension.orEmpty
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class VerifyTokenInterceptor(
    private val dataSource: AuthRepository,
    private val preferencesDao: PreferencesDao
) : HttpInterceptor {
    private val userData: Result<Boolean>
        get() = runBlocking {
            dataSource.isLogged()
        }

    private val mutex = Mutex()
    override suspend fun intercept(
        request: HttpRequest,
        chain: HttpInterceptorChain
    ): HttpResponse {
        var token = mutex.withLock {
            preferencesDao.let {
                return@let it.getTokenType().getOrNull().orEmpty() + " " +
                        it.getToken().getOrNull().orEmpty()
            }
        }

        val response =
            chain.proceed(request.newBuilder().addHeader(HEADER_PARAM_NAME, token).build())
        return if (response.statusCode == HttpStatusCode.Unauthorized.value && userData.getOrNull() == true) {
            mutex.withLock {
                dataSource.refreshToken().apply {
                    if (isSuccess) {
                        token = getOrNull()?.tokenType + " " + getOrNull()?.token
                    }
                }
            }
            chain.proceed(request.newBuilder().addHeader(HEADER_PARAM_NAME, token).build())
        } else {
            response
        }
    }

    companion object {
        const val HEADER_PARAM_NAME = "Authorization"
    }
}
