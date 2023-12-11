package com.cesarwillymc.kmplogin.framework.network

/**
 * Created by Cesar Canaza on 12/7/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
object HttpRoutes {
    private const val BASE_URL = "https://survey-api.nimblehq.co"
    object Auth {
        const val LOGIN = "$BASE_URL/api/v1/oauth/token"
        const val LOGOUT = "$BASE_URL/api/v1/oauth/revoke"
        const val REFRESH = "$BASE_URL/api/v1/oauth/token"
        const val FORGOT = "$BASE_URL/api/v1/passwords"
    }
}