package com.cesarwillymc.kmplogin.presentation.screens.auth.viewmodel

import com.cesarwillymc.kmplogin.domain.usecase.auth.ForgotUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.SignInUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.AuthParams
import com.cesarwillymc.kmplogin.presentation.screens.auth.state.AuthUiState
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.ViewModel
import com.cesarwillymc.kmplogin.presentation.validations.field.EmailField
import com.cesarwillymc.kmplogin.presentation.validations.field.PasswordField
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

class LoginViewModel: ViewModel(), KoinComponent {
    /** Dependency injection */
    private val signInUseCase = get<SignInUseCase>()

    /** Variables */
    val emailText = EmailField()
    val passwordText = PasswordField()

    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())

    /** Behaviors */
    fun login() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            signInUseCase(
                AuthParams(
                    email = emailText.text.value,
                    password = passwordText.text.value
                )
            ).let { result ->
                when {
                    result.isSuccess -> {
                        authUiState.update { AuthUiState(isSuccess = true) }
                    }

                    result.isFailure -> {
                        val messageError: String? = result.exceptionOrNull()?.message

                        authUiState.update {
                            AuthUiState(
                                isError = true,
                                errorMessage = messageError
                            )
                        }
                    }
                }
            }
        }
    }
}
