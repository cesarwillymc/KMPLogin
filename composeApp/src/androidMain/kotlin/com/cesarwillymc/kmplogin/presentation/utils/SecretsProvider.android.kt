package com.cesarwillymc.kmplogin.presentation.utils

import com.cesarwillymc.kmplogin.BuildConfig

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class SecretsProvider actual constructor() {

    actual fun getBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    actual fun getBaseUrlGraphQL(): String {
        return BuildConfig.BASE_URL_GQL
    }

    actual fun getClientId(): String {
        return BuildConfig.CLIENT_ID
    }

    actual fun getClientSecret(): String {
        return BuildConfig.CLIENT_SECRET
    }

    actual fun getDBName(): String {
        return BuildConfig.SHARED_PREFERENCES_NAME
    }
}
