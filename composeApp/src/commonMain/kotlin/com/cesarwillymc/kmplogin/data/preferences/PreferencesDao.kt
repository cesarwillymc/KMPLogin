package com.cesarwillymc.kmplogin.data.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesDao {

    suspend fun getToken(): Flow<String>
    suspend fun saveToken(value: String)
    suspend fun getRefreshToken(): Flow<String>
    suspend fun saveRefreshToken(value: String)
    suspend fun getTokenType(): Flow<String>
    suspend fun saveTokenType(value: String)

    suspend fun getIsLogged(): Flow<Boolean>
    suspend fun cleanPreferences()
}
