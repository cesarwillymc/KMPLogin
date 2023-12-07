package com.cesarwillymc.kmplogin.data.sources.preferences

interface PreferencesDao {

    val getToken: Result<String>
    fun saveToken(value: String): Result<Unit>
    val getRefreshToken: Result<String>
    fun saveRefreshToken(value: String): Result<Unit>
    val getTokenType: Result<String>
    fun saveTokenType(value: String): Result<Unit>

    val isLogged: Result<Boolean>
    fun cleanPreferences(): Result<Unit>
}
