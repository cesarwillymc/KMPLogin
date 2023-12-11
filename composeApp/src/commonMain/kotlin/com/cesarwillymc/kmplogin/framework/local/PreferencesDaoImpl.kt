package com.cesarwillymc.kmplogin.framework.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesDaoImpl(
    private val sharedPreferences: DataStore<Preferences>
) : PreferencesDao {

    private companion object {

        const val USER_SESSION = "user_information"
        const val USER_SESSION_TYPE = "user_information_type"
        const val USER_SESSION_REFRESH = "user_information_refresh"
    }

    override suspend fun getToken(): Flow<String> =
        sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION)].orEmpty() }

    override suspend fun saveToken(value: String) {
        sharedPreferences.edit {
            it[stringPreferencesKey(USER_SESSION)] = value
        }
    }

    override suspend fun getTokenType(): Flow<String> =
        sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION_TYPE)].orEmpty() }

    override suspend fun saveRefreshToken(value: String) {
        sharedPreferences.edit {
            it[stringPreferencesKey(USER_SESSION_REFRESH)] = value
        }
    }

    override suspend fun getRefreshToken(): Flow<String> =
        sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION_REFRESH)].orEmpty() }

    override suspend fun saveTokenType(value: String) {
        sharedPreferences.edit {
            it[stringPreferencesKey(USER_SESSION_TYPE)] = value
        }
    }

    override suspend fun getIsLogged(): Flow<Boolean> =
        sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION)].orEmpty().isNotEmpty() }

    override suspend fun cleanPreferences() {
        sharedPreferences.edit {
            it.remove(stringPreferencesKey(USER_SESSION))
            it.remove(stringPreferencesKey(USER_SESSION_TYPE))
        }
    }
}
