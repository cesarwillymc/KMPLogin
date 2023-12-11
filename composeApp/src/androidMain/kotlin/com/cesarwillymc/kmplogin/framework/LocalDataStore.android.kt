package com.cesarwillymc.kmplogin.framework

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.cesarwillymc.kmplogin.framework.local.createDataStore
import com.cesarwillymc.kmplogin.framework.local.dataStoreFileName


fun getDataStore(context: Context): DataStore<Preferences> {
    return createDataStore(
        producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
    )
}