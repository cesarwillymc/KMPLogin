package com.cesarwillymc.kmplogin.presentation.screens.auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.kmplogin.domain.usecase.auth.ForgotUseCase
import com.cesarwillymc.kmplogin.presentation.screens.auth.state.AuthUiState
import com.cesarwillymc.kmplogin.presentation.validations.field.EmailField
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
class ForgotViewModel @Inject constructor(
    private val forgotUseCase: ForgotUseCase
) : ViewModel() {
    val emailText = EmailField()
    val authUiState get() = _authUiState
    private val _authUiState = MutableStateFlow(AuthUiState())
    fun forgotPassword() {
        authUiState.update { AuthUiState(isLoading = true) }
        viewModelScope.launch {
            forgotUseCase(emailText.text.value).let { result ->
                authUiState.update {
                    AuthUiState(
                        isError = result.isError,
                        isSuccess = result.isSuccess
                    )
                }
            }
        }
    }
}
