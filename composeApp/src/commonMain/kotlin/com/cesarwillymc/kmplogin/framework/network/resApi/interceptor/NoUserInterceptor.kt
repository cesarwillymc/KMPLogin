package com.cesarwillymc.kmplogin.framework.network.resApi.interceptor

import com.cesarwillymc.kmplogin.util.constants.EMPTY_STRING
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.util.AttributeKey

/**
 * Created by Cesar Canaza on 12/7/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class NoUserInterceptor private constructor(configuration: Configuration) {
    private val queryParamId = configuration.queryParamId
    private val queryParamSecret = configuration.queryParamSecret
    private val queryNameClientId = "client_id"
    private val queryNameClientSecret = "client_secret"

    class Configuration {
        var queryParamId: String = EMPTY_STRING
        var queryParamSecret: String = EMPTY_STRING
    }

    companion object Plugin : HttpClientPlugin<Configuration, NoUserInterceptor> {
        override val key: AttributeKey<NoUserInterceptor>
            get() = AttributeKey("NoUserInterceptor")

        override fun prepare(block: Configuration.() -> Unit): NoUserInterceptor {
            val configuration = Configuration().apply(block)
            return NoUserInterceptor(configuration)
        }

        override fun install(plugin: NoUserInterceptor, scope: HttpClient) {
            scope.requestPipeline.intercept(HttpRequestPipeline.State) {
                context.url.parameters.append(plugin.queryNameClientId, plugin.queryParamId)
                context.url.parameters.append(plugin.queryNameClientSecret, plugin.queryParamSecret)
            }

        }
    }
}