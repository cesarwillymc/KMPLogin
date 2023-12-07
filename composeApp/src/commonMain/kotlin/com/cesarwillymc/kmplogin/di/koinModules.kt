package com.cesarwillymc.kmplogin.di

import com.cesarwillymc.kmplogin.data.settings.local.EncryptedSharedPreferencesFactory
import com.cesarwillymc.kmplogin.data.sources.auth.AuthRepositoryImpl
import com.cesarwillymc.kmplogin.domain.repository.AuthRepository
import com.cesarwillymc.kmplogin.data.sources.auth.mapper.AuthResultMapper
import com.cesarwillymc.kmplogin.data.sources.auth.mapper.AuthResultMapperImpl
import com.cesarwillymc.kmplogin.data.sources.auth.remote.AuthRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.auth.remote.AuthRemoteDataSourceImpl
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDao
import com.cesarwillymc.kmplogin.data.sources.preferences.PreferencesDaoImpl
import com.cesarwillymc.kmplogin.data.sources.survey.SurveyRepositoryImpl
import com.cesarwillymc.kmplogin.domain.repository.SurveyRepository
import com.cesarwillymc.kmplogin.data.sources.survey.mapper.SurveyMapper
import com.cesarwillymc.kmplogin.data.sources.survey.mapper.SurveyMapperImpl
import com.cesarwillymc.kmplogin.data.sources.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.kmplogin.data.sources.survey.remote.SurveyRemoteDataSourceImpl
import com.cesarwillymc.kmplogin.domain.usecase.auth.ForgotUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.GetLoggedStateUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.SignInUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.GetSurveysUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
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

val koinFrameworks = module {
    single {
        EncryptedSharedPreferencesFactory(
            BuildConfig.SHARED_PREFERENCES_NAME,
            androidContext()
        ).sharedPreferences
    }
}