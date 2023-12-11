package com.cesarwillymc.kmplogin.presentation.screens.home.viewmodel

import com.cesarwillymc.kmplogin.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.GetSurveysUseCase
import com.cesarwillymc.kmplogin.presentation.screens.auth.state.AuthUiState
import com.cesarwillymc.kmplogin.presentation.screens.home.state.HomeUiState
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.ViewModel
import com.cesarwillymc.kmplogin.util.constants.DELAY_1000
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

class HomeViewModel : ViewModel(), KoinComponent {
    /** Dependency injection */
    private val logoutUseCase = get<LogoutUseCase>()
    private val getSurveys = get<GetSurveysUseCase>()

    /** Variables */
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    val homeUiState get() = _homeUiState
    private val _homeUiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)

    init {
        onLoadSurveys()
    }

    /** Behaviors */
    fun onLoadSurveys() {
        _homeUiState.update { HomeUiState.Loading }
        viewModelScope.launch {
            getSurveys(Unit).let { result ->
                when {
                    result.isSuccess -> {
                        delay(DELAY_1000)
                        _homeUiState.update { HomeUiState.Success(result.getOrNull()) }
                    }

                    result.isFailure -> {
                        _homeUiState.update { HomeUiState.Error }
                    }
                }
            }
        }
    }

    fun logout() {
        _authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            logoutUseCase(Unit).let { result ->
                when {
                    result.isSuccess -> {
                        _authUiState.update { AuthUiState(isSuccess = true) }
                    }

                    result.isFailure -> {
                        _authUiState.update { AuthUiState(isError = true) }
                    }
                }
            }
        }
    }
}
