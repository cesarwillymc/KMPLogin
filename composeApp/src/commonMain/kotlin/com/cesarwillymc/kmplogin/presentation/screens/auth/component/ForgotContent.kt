package com.cesarwillymc.kmplogin.presentation.screens.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import com.cesarwillymc.kmplogin.presentation.composables.CustomPrimaryButton
import com.cesarwillymc.kmplogin.presentation.composables.CustomTextField
import com.cesarwillymc.kmplogin.presentation.validations.field.EmailField
import dev.icerock.moko.resources.compose.stringResource
import com.cesarwillymc.kmplogin.SharedRes as SharedRes1

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.ForgotContent(
    emailField: EmailField,
    onContinueEmail: () -> Unit
) {
    val isErrorEmail by emailField.isError.collectAsState()
    CustomTextField(
        query = emailField.text.collectAsState().value,
        onQueryChange = emailField::setText,
        keyboardType = KeyboardType.Email,
        hintText = stringResource(SharedRes1.strings.lbl_email),
        isError = emailField.isError.collectAsState().value
    )
    CustomPrimaryButton(
        title = stringResource(SharedRes1.strings.lbl_reset),
        textColor = Color.Black,
        onClick = onContinueEmail,
        isEnabled = !isErrorEmail
    )
}

