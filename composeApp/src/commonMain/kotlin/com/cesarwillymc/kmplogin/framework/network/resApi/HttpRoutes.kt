package com.cesarwillymc.kmplogin.framework.network.resApi

import com.cesarwillymc.kmplogin.presentation.utils.SecretsProvider

/**
 * Created by Cesar Canaza on 12/7/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
object HttpRoutes {
    private val BASE_URL = SecretsProvider().getBaseUrl()

    object Auth {
        val LOGIN = "$BASE_URL/api/v1/oauth/token"
        val LOGOUT = "$BASE_URL/api/v1/oauth/revoke"
        val REFRESH = "$BASE_URL/api/v1/oauth/token"
        val FORGOT = "$BASE_URL/api/v1/passwords"
    }
}