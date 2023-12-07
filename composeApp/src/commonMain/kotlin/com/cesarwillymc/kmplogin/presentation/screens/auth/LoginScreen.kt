package com.cesarwillymc.kmplogin.presentation.screens.auth

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.composables.CustomFullScreenLoading
import com.cesarwillymc.kmplogin.presentation.composables.CustomSnackbar
import com.cesarwillymc.kmplogin.presentation.navigation.event.SignInEvent
import com.cesarwillymc.kmplogin.presentation.screens.auth.component.AuthScaffold
import com.cesarwillymc.kmplogin.presentation.screens.auth.component.SignInContent
import com.cesarwillymc.kmplogin.presentation.screens.auth.viewmodel.LoginViewModel
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.rememberViewModel
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun LoginScreen(
    event: SignInEvent
) {
    val loginViewModel = rememberViewModel(LoginViewModel::class){
        LoginViewModel()
    }
    val passwordField = loginViewModel.passwordText
    val emailText = loginViewModel.emailText
    val authUiState by loginViewModel.authUiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    CustomFullScreenLoading(authUiState.isLoading)
    AuthScaffold(
        isIconsTopEnabled = false
    ) {
        SignInContent(
            emailText = emailText,
            passwordField = passwordField,
            onContinue = loginViewModel::login,
            onClickForgotPassword = event::navigateToForgotPassword
        )
    }
    CustomSnackbar(snackbarHostState = snackbarHostState)
    val message = stringResource(SharedRes.strings.desc_error_snackbar)
    val actionLabel = stringResource(SharedRes.strings.lbl_error)
    LaunchedEffect(authUiState) {

        if (authUiState.isError) {
            snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = SnackbarDuration.Long,
                withDismissAction = true
            )
        }
        if (authUiState.isSuccess) {
            event.navigateToForgotPassword()
        }
    }
}
