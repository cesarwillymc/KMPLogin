package com.cesarwillymc.kmplogin.presentation.screens.auth.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.cesarwillymc.kmplogin.presentation.composables.CustomPrimaryButton
import com.cesarwillymc.kmplogin.presentation.composables.CustomTextField
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColorOpacity
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
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

    Text(
        stringResource(SharedRes1.strings.lbl_forgot_password_description),
        color = TextColorOpacity,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(bottom = DimensionManager.getPadding(PaddingType.Large))
    )
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

