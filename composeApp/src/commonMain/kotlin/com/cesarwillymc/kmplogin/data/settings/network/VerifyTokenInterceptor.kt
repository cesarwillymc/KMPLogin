package com.cesarwillymc.kmplogin.data.settings.network

import com.cesarwillymc.kmplogin.data.settings.network.SessionInterceptor.Companion.TOKEN_KEY
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.util.constants.EMPTY_STRING
import com.cesarwillymc.kmplogin.util.extension.orEmpty
import com.cesarwillymc.kmplogin.util.state.dataOrNull
import com.cesarwillymc.kmplogin.util.state.getData
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class VerifyTokenInterceptor @Inject constructor(
    private val dataSource: AuthRepository
) : Authenticator {
    private val userData: Result<Boolean>
        get() = runBlocking {
            dataSource.isLogged()
        }

    override fun authenticate(route: Route?, response: Response): Request? {
        var session: String = EMPTY_STRING
        if (userData.dataOrNull().orEmpty()) {
            runBlocking {
                dataSource.refreshToken().apply {
                    if (isSuccess) {
                        session = getData().tokenType + " " + getData().token
                    }
                }
            }
        }
        return response.request.newBuilder()
            .removeHeader(TOKEN_KEY)
            .header(TOKEN_KEY, session)
            .build()
    }
}
