package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.util.constants.EMPTY_STRING
import com.cesarwillymc.kmplogin.util.constants.FRACTION_30
import com.cesarwillymc.kmplogin.util.constants.ONE

/**
 * Created by Cesar Canaza on 10/3/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

/** TextFieldValue control the cursor position **/
@Composable
fun CustomTextField(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hintText: String = EMPTY_STRING,
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    enableAnimationHint: Boolean = false,
    trailingComposable: (@Composable () -> Unit)? = null,
    isTypePassword: Boolean = false,
) {
    var isFocused by remember { mutableStateOf(false) }
    val keyboardController = LocalTextInputService.current

    BasicTextField(
        value = query,
        modifier = modifier
            .fillMaxWidth()
            .height(DimensionManager.getPadding(PaddingType.Large))
            .onFocusChanged {
                isFocused = it.isFocused
            }
            .background(
                MaterialTheme.colorScheme.background.copy(alpha = FRACTION_30),
                shape = RoundedCornerShape(DimensionManager.getPadding(PaddingType.Small))
            )
            .border(
                width = ONE.dp,
                color = when {
                    query.isNotBlank() && !isError -> Color.Transparent
                    query.isBlank() -> Color.Transparent
                    else -> Color.Red
                },
                RoundedCornerShape(DimensionManager.getPadding(PaddingType.Small))
            ),
        onValueChange = onQueryChange,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = TextColor),
        maxLines = ONE,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Go
        ),
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
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier,
                ) {
                    Box(
                        modifier = Modifier
                            .padding(DimensionManager.getPadding(PaddingType.Small))
                            .align(
                                Alignment.CenterStart
                            )
                    ) {
                        innerTextField()
                    }

                    if (hintText.isNotEmpty() && (!(isFocused || query.isNotBlank()) || enableAnimationHint)) {
                        Text(
                            text = hintText,
                            style = if (isFocused) {
                                MaterialTheme.typography.bodySmall
                            } else {
                                MaterialTheme.typography.bodyMedium
                            },
                            modifier = Modifier
                                .align(
                                    if (isFocused || query.isNotBlank()) {
                                        Alignment.TopStart
                                    } else {
                                        Alignment.CenterStart
                                    }
                                )
                                .padding(start = DimensionManager.getPadding(PaddingType.Small)),
                            color = TextColor
                        )
                    }
                }
                trailingComposable?.let { it() }
            }
        }
    )
}