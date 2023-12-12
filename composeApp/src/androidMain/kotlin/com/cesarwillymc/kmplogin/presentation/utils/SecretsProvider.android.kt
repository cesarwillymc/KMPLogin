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

    // Get the current working directory
    val currentDir = System.getProperty("user.dir")

    // Navigate to the parent directory
    val parentDir = currentDir?.let { File(it).parentFile }

    // Construct the path to local.properties
    val localPropertiesFile = File(parentDir, "local.properties")

    if (localPropertiesFile.exists()) {
        // Load properties if the file exists
        val inputStream = localPropertiesFile.inputStream()
        properties.load(inputStream)
        val data = properties.getProperty(name).orEmpty()
        println("RESOURCEAAA $name: $data")
        return data
    } else {
        println("Local properties file does not exist.")
        // Handle the case when the file does not exist.
        return ""
    }
}