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
import com.cesarwillymc.kmplogin.presentation.navigation.event.ForgotPasswordEvent
import com.cesarwillymc.kmplogin.presentation.screens.auth.component.AuthScaffold
import com.cesarwillymc.kmplogin.presentation.screens.auth.component.ForgotContent
import com.cesarwillymc.kmplogin.presentation.screens.auth.viewmodel.ForgotViewModel
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.rememberViewModel
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ForgotScreen(
    event: ForgotPasswordEvent
) {
    val forgotViewModel = rememberViewModel(ForgotViewModel::class){
        ForgotViewModel()
    }
    val authUiState by forgotViewModel.authUiState.collectAsState()
    val emailField = forgotViewModel.emailText
    val snackbarHostState = remember { SnackbarHostState() }

    AuthScaffold(
        isIconsTopEnabled = true,
        onNavigateUp = event::onBack
    ) {
        ForgotContent(
            emailField = emailField,
            onContinueEmail = forgotViewModel::forgotPassword
        )
    }
    CustomSnackbar(snackbarHostState = snackbarHostState)
    CustomFullScreenLoading(authUiState.isLoading)
    val message = stringResource(SharedRes.strings.desc_error_snackbar)
    val actionLabel = stringResource(SharedRes.strings.lbl_error)
    LaunchedEffect(authUiState) {
        when {
            authUiState.isSuccess -> {
//                context.createNotificationChannel()
//                context.showNotification()
            }
            authUiState.isError -> {
                snackbarHostState.showSnackbar(
                    message = message,
                    actionLabel = actionLabel,
                    duration = SnackbarDuration.Long,
                    withDismissAction = true
                )
            }
        }
    }
}
