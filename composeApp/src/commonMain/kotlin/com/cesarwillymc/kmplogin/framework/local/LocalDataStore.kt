package com.cesarwillymc.kmplogin.framework.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

/**
 * Created by Cesar Canaza on 12/7/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
internal const val dataStoreFileName = "meetings.preferences_pb"
internal fun createDataStore(
    producePath: () -> String,
): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
    corruptionHandler = null,
    migrations = emptyList(),
    produceFile = { producePath().toPath() }
)
