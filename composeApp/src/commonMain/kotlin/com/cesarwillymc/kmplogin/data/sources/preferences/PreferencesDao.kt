package com.cesarwillymc.kmplogin.data.sources.preferences

interface PreferencesDao {

    suspend fun getToken(): Result<String>
    suspend fun saveToken(value: String): Result<Unit>
    suspend fun getRefreshToken(): Result<String>
    suspend fun saveRefreshToken(value: String): Result<Unit>
    suspend fun getTokenType(): Result<String>
    suspend fun saveTokenType(value: String): Result<Unit>

    suspend fun getIsLogged(): Result<Boolean>
    suspend fun cleanPreferences(): Result<Unit>
}
