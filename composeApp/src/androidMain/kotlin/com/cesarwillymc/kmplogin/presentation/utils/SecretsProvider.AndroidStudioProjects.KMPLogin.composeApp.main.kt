package com.cesarwillymc.kmplogin.presentation.utils

import java.io.File
import java.util.Properties

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class SecretsProvider actual constructor() {

    actual fun getBaseUrl(): String {
        return getLocalPropertyValue(LP_BASE_URL)
    }

    actual fun getBaseUrlGraphQL(): String {
        return getLocalPropertyValue(LP_BASE_URL_GQL)
    }

    actual fun getClientId(): String {
        return getLocalPropertyValue(LP_CLIENT_ID)
    }

    actual fun getClientSecret(): String {
        return getLocalPropertyValue(LP_CLIENT_SECRET)
    }

    actual fun getDBName(): String {
        return getLocalPropertyValue(LP_SHARED_PREFERENCES_NAME)
    }
}
internal fun getLocalPropertyValue(name:String): String {
    val properties = Properties()
    val localPropertiesFile = File("../local.properties")
    val inputStream = localPropertiesFile.inputStream()
    properties.load(inputStream)
    return properties.getProperty(name).orEmpty()
}