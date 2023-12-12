package com.cesarwillymc.kmplogin.presentation.utils

import platform.Foundation.NSBundle

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
private const val LP_BASE_URL = "BASE_URL"
private const val LP_BASE_URL_GQL = "BASE_URL_GQL"
private const val LP_CLIENT_ID = "CLIENT_ID"
private const val LP_CLIENT_SECRET = "CLIENT_SECRET"
private const val LP_SHARED_PREFERENCES_NAME = "SHARED_PREFERENCES_NAME"

actual class SecretsProvider actual constructor() {

    actual fun getBaseUrl(): String {
        return (NSBundle.mainBundle.objectForInfoDictionaryKey(LP_BASE_URL) as? String).orEmpty()
    }

    actual fun getBaseUrlGraphQL(): String {
        return (NSBundle.mainBundle.objectForInfoDictionaryKey(LP_BASE_URL_GQL) as? String).orEmpty()
    }

    actual fun getClientId(): String {
        return (NSBundle.mainBundle.objectForInfoDictionaryKey(LP_CLIENT_ID) as? String).orEmpty()
    }

    actual fun getClientSecret(): String {
        return (NSBundle.mainBundle.objectForInfoDictionaryKey(LP_CLIENT_SECRET) as? String).orEmpty()
    }

    actual fun getDBName(): String {
        return (NSBundle.mainBundle.objectForInfoDictionaryKey(LP_SHARED_PREFERENCES_NAME) as? String).orEmpty()
    }
}
