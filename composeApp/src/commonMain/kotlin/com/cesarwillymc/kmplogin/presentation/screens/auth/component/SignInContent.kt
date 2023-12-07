package com.cesarwillymc.kmplogin.presentation.screens.auth.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.composables.CustomPrimaryButton
import com.cesarwillymc.kmplogin.presentation.composables.CustomTextField
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColorOpacity
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.presentation.validations.field.EmailField
import com.cesarwillymc.kmplogin.presentation.validations.field.PasswordField
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ColumnScope.SignInContent(
    passwordField: PasswordField,
    emailText: EmailField,
    onContinue: () -> Unit,
    onClickForgotPassword: () -> Unit

) {
    val isErrorPassword by passwordField.isError.collectAsState()
    val isErrorEmail by emailText.isError.collectAsState()

    CustomTextField(
        query = emailText.text.collectAsState().value,
        onQueryChange = emailText::setText,
        hintText = stringResource(SharedRes.strings.lbl_email),
        isError = isErrorEmail
    )
    CustomTextField(
        query = passwordField.text.collectAsState().value,
        onQueryChange = passwordField::setText,
        hintText = stringResource(SharedRes.strings.lbl_password),
        isTypePassword = true,
        isError = isErrorPassword,
        trailingComposable = {
            Text(
                text = stringResource(SharedRes.strings.lbl_forgot),
                modifier = Modifier
                    .padding(end = DimensionManager.getPadding(PaddingType.Small))
                    .clickable {
                        onClickForgotPassword()
                    },
                color = TextColorOpacity
            )
        }
    )
    CustomPrimaryButton(
        title = stringResource(SharedRes.strings.til_sign_in),
        onClick = onContinue,
        isEnabled = !(isErrorPassword || isErrorEmail)
    )
}