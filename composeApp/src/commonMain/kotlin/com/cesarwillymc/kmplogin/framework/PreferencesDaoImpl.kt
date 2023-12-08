package com.cesarwillymc.kmplogin.framework

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.map

class PreferencesDaoImpl (
    private val sharedPreferences: DataStore<Preferences>
) : PreferencesDao {

    private companion object {

        const val USER_SESSION = "user_information"
        const val USER_SESSION_TYPE = "user_information_type"
        const val USER_SESSION_REFRESH = "user_information_refresh"
    }

    override suspend fun getToken(): Result<String> = try {
        val session =
            sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION)] }.lastOrNull()
        Result.success(session.orEmpty())
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun saveToken(value: String): Result<Unit> {
        sharedPreferences.edit {
            it[stringPreferencesKey(USER_SESSION)] = value
        }
        return Result.success(Unit)
    }

    override suspend fun getTokenType(): Result<String> = try {
        val session =
            sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION_TYPE)] }.lastOrNull()
        Result.success(session.orEmpty())
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun saveRefreshToken(value: String): Result<Unit> {
        sharedPreferences.edit {
            it[stringPreferencesKey(USER_SESSION_REFRESH)] = value
        }
        return Result.success(Unit)
    }

    override suspend fun getRefreshToken(): Result<String> = try {
        val session = sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION_REFRESH)] }
            .lastOrNull()
        Result.success(session.orEmpty())
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun saveTokenType(value: String): Result<Unit> {
        sharedPreferences.edit {
            it[stringPreferencesKey(USER_SESSION_TYPE)] = value
        }
        return Result.success(Unit)
    }

    override suspend fun getIsLogged(): Result<Boolean> = try {
        val session =
            sharedPreferences.data.map { it[stringPreferencesKey(USER_SESSION)] }.lastOrNull()
        Result.success(session.isNullOrBlank())
    } catch (e: Exception) {
        Result.failure(e)
    }

    override suspend fun cleanPreferences(): Result<Unit> {
        sharedPreferences.edit {
            it.remove(stringPreferencesKey(USER_SESSION))
            it.remove(stringPreferencesKey(USER_SESSION_TYPE))
        }
        return Result.success(Unit)
    }
}
