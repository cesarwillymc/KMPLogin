package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.util.constants.ONE
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun CustomLottieMessage(
    lottieCompose:@Composable ()->Unit,
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    onClickRetry: () -> Unit = {},
    showRetryButton: Boolean = false
) {

    Box(modifier = modifier.fillMaxSize().statusBarsPadding()) {
        Column(
            modifier = modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                DimensionManager.getPadding(PaddingType.Medium)
            )
        ) {
            lottieCompose()
            Divider(modifier = Modifier.padding( DimensionManager.getPadding(PaddingType.Medium)))
            Text(text = title, style = MaterialTheme.typography.titleLarge)
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    DimensionManager.getPadding(PaddingType.Medium)
                ),
                textAlign = TextAlign.Justify
            )
            if (showRetryButton) {
                TextButton(
                    onClick = onClickRetry,
                    border = BorderStroke(
                        ONE.dp,
                        MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        stringResource(SharedRes.strings.til_try_again),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}