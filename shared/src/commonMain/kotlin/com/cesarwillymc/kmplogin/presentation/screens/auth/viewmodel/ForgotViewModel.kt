package com.cesarwillymc.kmplogin.presentation.screens.auth.viewmodel

import com.cesarwillymc.kmplogin.domain.usecase.auth.ForgotUseCase
import com.cesarwillymc.kmplogin.presentation.screens.auth.state.AuthUiState
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.ViewModel
import com.cesarwillymc.kmplogin.presentation.validations.field.EmailField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class ForgotViewModel (
    private val forgotUseCase: ForgotUseCase
) : ViewModel(), KoinComponent {
    val emailText = EmailField()
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun forgotPassword() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            forgotUseCase(emailText.text.value).let { result ->
                authUiState.update {
                    AuthUiState(
                        isError = result.isFailure,
                        isSuccess = result.isSuccess
                    )
                }
            }
        }
    }
}
