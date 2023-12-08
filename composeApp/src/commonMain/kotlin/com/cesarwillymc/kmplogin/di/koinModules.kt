package com.cesarwillymc.kmplogin.di

import com.apollographql.apollo3.ApolloClient
import com.cesarwillymc.kmplogin.data.sources.auth.AuthRepositoryImpl
import com.cesarwillymc.kmplogin.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.kmplogin.data.sources.auth.mapper.AuthResultMapperImpl
import com.cesarwillymc.kmplogin.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import com.cesarwillymc.kmplogin.data.sources.survey.SurveyRepositoryImpl
import com.cesarwillymc.kmplogin.data.sources.survey.mapper.SurveyMapper
import com.cesarwillymc.kmplogin.data.sources.survey.mapper.SurveyMapperImpl
import com.cesarwillymc.kmplogin.data.sources.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.survey.remote.SurveyRemoteDataSourceImpl
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.domain.repository.SurveyRepository
import com.cesarwillymc.kmplogin.domain.usecase.auth.ForgotUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.GetLoggedStateUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.SignInUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.GetSurveysUseCase
import com.cesarwillymc.kmplogin.framework.PreferencesDaoImpl
import com.cesarwillymc.kmplogin.framework.network.AuthRemoteDataSourceImpl
import com.cesarwillymc.kmplogin.framework.network.NoUserInterceptor
import com.cesarwillymc.kmplogin.framework.network.VerifyTokenInterceptor
import com.cesarwillymc.kmplogin.framework.util.CoroutinesModule
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Cesar Canaza on 12/6/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

val koinModuleUseCase = module {

    single<GetSurveysUseCase> {
        GetSurveysUseCase(
            repository = get(),
            dispatcher = get(named(CoroutinesModule.IO))
        )
    }
    single<ForgotUseCase> {
        ForgotUseCase(
            repository = get(),
            dispatcher = get(named(CoroutinesModule.IO))
        )
    }
    single<GetLoggedStateUseCase> {
        GetLoggedStateUseCase(
            repository = get(),
            dispatcher = get(named(CoroutinesModule.IO))
        )
    }
    single<LogoutUseCase> {
        LogoutUseCase(
            repository = get(),
            dispatcher = get(named(CoroutinesModule.IO))
        )
    }
    single<SignInUseCase> {
        SignInUseCase(
            repository = get(),
            dispatcher = get(named(CoroutinesModule.IO))
        )
    }

    single<SurveyRepository> {
        SurveyRepositoryImpl(
            surveyRemoteDataSource = get(),
            mapper = get()
        )
    }
    single<AuthRepository> {
        AuthRepositoryImpl(
            remoteDataSource = get(),
            resultMapper = get(),
            sharedDao = get()
        )
    }
}
val koinModuleData = module {


    single<SurveyRemoteDataSource> { SurveyRemoteDataSourceImpl(get()) }
    single<SurveyMapper> { SurveyMapperImpl() }
    single<AuthRemoteDataSource> { AuthRemoteDataSourceImpl(get()) }
    single<AuthResultMapper> { AuthResultMapperImpl() }
    single<PreferencesDao> { PreferencesDaoImpl(get()) }
}
val koinDispatcherModule = module {
    single<CoroutineDispatcher>(named(CoroutinesModule.DEFAULT)) { Dispatchers.Default }
    single<CoroutineDispatcher>(named(CoroutinesModule.IO)) { Dispatchers.IO }
    single<CoroutineDispatcher>(named(CoroutinesModule.MAIN)) { Dispatchers.Main }
}
expect val platformModule: Module

val koinFrameworks = module {
    single<HttpClient> {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        useAlternativeNames = false
                    }
                )
            }
            install(NoUserInterceptor) {
                queryParamId = ""
                queryParamSecret = ""
            }
        }
    }
    single { VerifyTokenInterceptor(get(),get()) }
    single {
        ApolloClient.Builder()
            .serverUrl("BuildConfig.BASE_URL_GQL")
            .addHttpInterceptor(get<VerifyTokenInterceptor>())
            .build()
    }
}