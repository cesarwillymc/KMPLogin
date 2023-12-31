package com.cesarwillymc.kmplogin.framework

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cesarwillymc.kmplogin.framework.local.createDataStore
import com.cesarwillymc.kmplogin.framework.local.dataStoreFileName
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
fun getDataStore(): DataStore<Preferences> {
    return createDataStore(
        producePath = {
            val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null,
            )
            requireNotNull(documentDirectory).path + "/$dataStoreFileName"
        }
    )
}