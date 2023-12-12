package com.cesarwillymc.kmplogin.presentation.utils

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

expect class SecretsProvider() {
    fun getBaseUrl(): String
    fun getBaseUrlGraphQL(): String
    fun getClientId(): String
    fun getClientSecret(): String
    fun getDBName(): String
}