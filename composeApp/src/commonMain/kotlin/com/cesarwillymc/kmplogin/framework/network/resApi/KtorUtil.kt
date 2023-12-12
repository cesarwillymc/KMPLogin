package com.cesarwillymc.kmplogin.framework.network.resApi

import com.cesarwillymc.kmplogin.framework.network.resApi.interceptor.NoUserInterceptor
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
internal fun getKtorInstance(clientId: String, secret: String): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                    encodeDefaults = true
                }
            )
        }
        install(NoUserInterceptor) {
            queryParamId = clientId
            queryParamSecret = secret
        }
    }
}