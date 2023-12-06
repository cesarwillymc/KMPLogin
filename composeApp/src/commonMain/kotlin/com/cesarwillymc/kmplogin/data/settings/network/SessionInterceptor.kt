package com.cesarwillymc.kmplogin.data.settings.network

import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import com.cesarwillymc.kmplogin.util.extension.orEmpty
import com.cesarwillymc.kmplogin.util.state.dataOrNull
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

// Here the token could be used
class SessionInterceptor @Inject constructor(
    private val preferencesDao: PreferencesDao
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val interceptor = chain
            .request()
            .newBuilder().apply {
                addHeader(TOKEN_KEY, getToken())
            }
            .build()

        return chain.proceed(interceptor)
    }

    private fun getToken(): String {
        return preferencesDao.let {
            return@let it.getTokenType.dataOrNull().orEmpty() + " " +
                it.getToken.dataOrNull().orEmpty()
        }
    }

    companion object {
        const val TOKEN_KEY = "Authorization"
    }
}
