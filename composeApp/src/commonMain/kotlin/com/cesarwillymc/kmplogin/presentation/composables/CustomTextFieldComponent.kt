package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColor
import com.cesarwillymc.kmplogin.presentation.theme.TextColorOpacity
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.util.constants.EMPTY_STRING
import com.cesarwillymc.kmplogin.util.constants.FRACTION_30
import com.cesarwillymc.kmplogin.util.constants.FRACTION_40
import com.cesarwillymc.kmplogin.util.constants.ONE

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

/** TextFieldValue control the cursor position **/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hintText: String = EMPTY_STRING,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    enableAnimationHint: Boolean = true,
    trailingComposable: @Composable () -> Unit = {},
    isTypePassword: Boolean = false,
) {
    var isFocused by remember { mutableStateOf(false) }
    val keyboardController = LocalTextInputService.current
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = query,
        modifier = modifier
            .onFocusChanged {
                isFocused = it.isFocused
            }.fillMaxWidth(),
        onValueChange = onQueryChange,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = TextColor),
        maxLines = ONE,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Go
        ),
        interactionSource = interactionSource,
        keyboardActions = KeyboardActions(
            onGo = {
                keyboardController?.hideSoftwareKeyboard()
            }
        ),
        visualTransformation = if (isTypePassword) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        decorationBox = { innerTextField ->

            TextFieldDefaults.DecorationBox(
                value = query,
                innerTextField = innerTextField,
                visualTransformation = if (isTypePassword) {
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                },
                placeholder = {
                    Text(
                        text = hintText,
                        style = if (isFocused) {
                            MaterialTheme.typography.bodySmall
                        } else {
                            MaterialTheme.typography.bodyMedium
                        },
                        modifier = Modifier
                            .padding(start = DimensionManager.getPadding(PaddingType.Small)),
                        color = TextColor
                    )
                },
                suffix = {
                    Box { trailingComposable.invoke() }
                },
                singleLine = true,
                enabled = true,
                interactionSource = interactionSource,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent

                ),
                container = {
                    Box(
                        modifier = Modifier.background(
                            MaterialTheme.colorScheme.background.copy(alpha = FRACTION_30),
                            shape = RoundedCornerShape(DimensionManager.getPadding(PaddingType.Small))
                        )
                            .border(
                                width = FRACTION_40.dp,
                                color = when {
                                    query.isNotBlank() && !isError -> Color.Transparent
                                    query.isBlank() -> Color.Transparent
                                    else -> Color.Red
                                },
                                RoundedCornerShape(DimensionManager.getPadding(PaddingType.Small))
                            )
                    ) {
                        if (query.isNotEmpty() && enableAnimationHint) {
                            Text(
                                text = hintText,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier
                                    .padding(start = DimensionManager.getPadding(PaddingType.Small))
                                    .align(Alignment.TopStart),
                                color = TextColorOpacity
                            )
                        }
                    }
                }

            )
        }
    )
}