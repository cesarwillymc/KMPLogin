package com.cesarwillymc.kmplogin.framework

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences


fun getDataStore(context: Context): DataStore<Preferences> {
    return createDataStore(
        producePath = { context.filesDir.resolve(dataStoreFileName).absolutePath }
    )
}