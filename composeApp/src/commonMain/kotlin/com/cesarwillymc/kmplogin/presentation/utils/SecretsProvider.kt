package com.cesarwillymc.kmplogin.presentation.utils

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

internal const val LP_BASE_URL = "BASE_URL"
internal const val LP_BASE_URL_GQL = "BASE_URL_GQL"
internal const val LP_CLIENT_ID = "CLIENT_ID"
internal const val LP_CLIENT_SECRET = "CLIENT_SECRET"
internal const val LP_SHARED_PREFERENCES_NAME = "SHARED_PREFERENCES_NAME"

expect class SecretsProvider() {
    fun getBaseUrl(): String
    fun getBaseUrlGraphQL(): String
    fun getClientId(): String
    fun getClientSecret(): String
    fun getDBName(): String
}