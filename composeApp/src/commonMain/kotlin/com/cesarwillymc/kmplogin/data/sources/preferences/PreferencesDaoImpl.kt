package com.cesarwillymc.kmplogin.data.sources.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import com.cesarwillymc.kmplogin.util.constants.EMPTY_STRING

class PreferencesDaoImpl constructor(
    private val sharedPreferences: SharedPreferences
) : PreferencesDao {

    private companion object {

        const val USER_SESSION = "user_information"
        const val USER_SESSION_TYPE = "user_information_type"
        const val USER_SESSION_REFRESH = "user_information_refresg"
    }

    override val getToken: Result<String>
        get() = try {
            val session = sharedPreferences.getString(USER_SESSION, EMPTY_STRING)
            Result.success(session.orEmpty())
        } catch (e: Exception) {
            Result.failure(e)
        }

    override fun saveToken(value: String): Result<Unit> {
        sharedPreferences.edit {
            this.putString(USER_SESSION, value)
        }
        return Result.success(Unit)
    }
    override val getTokenType: Result<String>
        get() = try {
            val session = sharedPreferences.getString(USER_SESSION_TYPE, EMPTY_STRING)
            Result.success(session.orEmpty())
        } catch (e: Exception) {
            Result.failure(e)
        }

    override fun saveRefreshToken(value: String): Result<Unit> {
        sharedPreferences.edit {
            this.putString(USER_SESSION_REFRESH, value)
        }
        return Result.success(Unit)
    }
    override val getRefreshToken: Result<String>
        get() = try {
            val session = sharedPreferences.getString(USER_SESSION_REFRESH, EMPTY_STRING)
            Result.success(session.orEmpty())
        } catch (e: Exception) {
            Result.failure(e)
        }

    override fun saveTokenType(value: String): Result<Unit> {
        sharedPreferences.edit {
            this.putString(USER_SESSION_TYPE, value)
        }
        return Result.success(Unit)
    }

    override val isLogged: Result<Boolean>
        get() = try {
            val session = sharedPreferences.getString(USER_SESSION, EMPTY_STRING)
            Result.success(!session.isNullOrBlank())
        } catch (e: Exception) {
            Result.failure(e)
        }

    override fun cleanPreferences(): Result<Unit> {
        sharedPreferences.edit {
            remove(USER_SESSION)
            remove(USER_SESSION_TYPE)
        }
        return Result.success(Unit)
    }
}
