package com.cesarwillymc.kmplogin.presentation.screens.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.kmplogin.domain.usecase.auth.LogoutUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.GetSurveysUseCase
import com.cesarwillymc.kmplogin.presentation.screens.auth.state.AuthUiState
import com.cesarwillymc.kmplogin.presentation.screens.home.state.HomeUiState
import com.cesarwillymc.kmplogin.util.constants.DELAY_1000
import com.cesarwillymc.kmplogin.util.state.dataOrNull
import com.cesarwillymc.kmplogin.util.state.isError
import com.cesarwillymc.kmplogin.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase,
    private val getSurveys: GetSurveysUseCase
) : ViewModel() {
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    val homeUiState get() = _homeUiState
    private val _homeUiState = MutableStateFlow(HomeUiState())

    init {
        onLoadSurveys()
    }
    fun onLoadSurveys() {
        _homeUiState.update { HomeUiState(isLoading = true) }
        viewModelScope.launch {
            getSurveys(Unit).let { result ->
                when {
                    result.isSuccess -> {
                        delay(DELAY_1000)
                        _homeUiState.update { HomeUiState(isSuccess = true, data = result.dataOrNull()) }
                    }

                    result.isError -> {
                        _homeUiState.update { HomeUiState(isError = true) }
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

                    result.isError -> {
                        _authUiState.update { AuthUiState(isError = true) }
                    }
                }
            }
        }
    }
}
