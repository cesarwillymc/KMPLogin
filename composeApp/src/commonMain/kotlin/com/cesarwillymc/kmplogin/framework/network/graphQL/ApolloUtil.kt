package com.cesarwillymc.kmplogin.framework.network.graphQL

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.cesarwillymc.kmplogin.framework.network.resApi.interceptor.VerifyTokenInterceptor

/**
 * Created by Cesar Canaza on 12/11/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
internal fun getApolloInstance(httpInterceptor: HttpInterceptor, url:String){
    ApolloClient.Builder()
        .serverUrl(url)
        .addHttpInterceptor(httpInterceptor)
        .build()
}