package com.cesarwillymc.kmplogin.di

import com.cesarwillymc.kmplogin.data.auth.AuthRepositoryImpl
import com.cesarwillymc.kmplogin.data.auth.mapper.AuthResultMapper
import com.cesarwillymc.kmplogin.data.auth.mapper.AuthResultMapperImpl
import com.cesarwillymc.kmplogin.data.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.kmplogin.data.preferences.PreferencesDao
import com.cesarwillymc.kmplogin.data.survey.SurveyRepositoryImpl
import com.cesarwillymc.kmplogin.data.survey.mapper.SurveyMapper
import com.cesarwillymc.kmplogin.data.survey.mapper.SurveyMapperImpl
import com.cesarwillymc.kmplogin.data.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.kmplogin.data.survey.remote.SurveyRemoteDataSourceImpl
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.domain.repository.SurveyRepository
import com.cesarwillymc.kmplogin.domain.usecase.auth.ForgotUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.GetLoggedStateUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.SignInUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.GetSurveysUseCase
import com.cesarwillymc.kmplogin.framework.local.PreferencesDaoImpl
import com.cesarwillymc.kmplogin.framework.network.graphQL.getApolloInstance
import com.cesarwillymc.kmplogin.framework.network.resApi.AuthRemoteDataSourceImpl
import com.cesarwillymc.kmplogin.framework.network.resApi.getKtorInstance
import com.cesarwillymc.kmplogin.framework.network.resApi.interceptor.VerifyTokenInterceptor
import com.cesarwillymc.kmplogin.presentation.utils.SecretsProvider
import com.cesarwillymc.kmplogin.util.CoroutinesModule
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
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
        getKtorInstance(
            get<SecretsProvider>().getClientId(),
            get<SecretsProvider>().getClientSecret()
        )
    }
    single { VerifyTokenInterceptor(get(), get()) }
    single {
        getApolloInstance(get<VerifyTokenInterceptor>(), get<SecretsProvider>().getBaseUrlGraphQL())
    }
    single { SecretsProvider() }
}