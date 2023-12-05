package com.cesarwillymc.kmplogin.presentation.screens.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.kmplogin.data.settings.network.util.error.ErrorSource
import com.cesarwillymc.kmplogin.domain.usecase.auth.SignInUseCase
import com.cesarwillymc.kmplogin.domain.usecase.auth.entities.AuthParams
import com.cesarwillymc.kmplogin.presentation.screens.auth.state.AuthUiState
import com.cesarwillymc.kmplogin.presentation.validations.field.EmailField
import com.cesarwillymc.kmplogin.presentation.validations.field.PasswordField
import com.cesarwillymc.kmplogin.util.state.getError
import com.cesarwillymc.kmplogin.util.state.isError
import com.cesarwillymc.kmplogin.util.state.isSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
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
class LoginViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {
    val emailText = EmailField()
    val passwordText = PasswordField()

    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
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

                    result.isError -> {
                        var messageError: String? = result.getError().message
                        if (result.getError() is ErrorSource.ServiceError) {
                            messageError = (result.getError() as ErrorSource.ServiceError).errorMessage
                        }
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
