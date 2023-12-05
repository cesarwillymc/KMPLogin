package com.cesarwillymc.kmplogin.presentation.composables

import androidx.annotation.RawRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cesarwillymc.kmplogin.R
import com.cesarwillymc.kmplogin.SharedRes
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
                dimensionResource(id = R.dimen.Normal100)
            )
        ) {
            lottieCompose()
            Divider(modifier = Modifier.padding(dimensionResource(id = R.dimen.Normal100)))
            Text(text = title, style = MaterialTheme.typography.titleLarge)
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    dimensionResource(id = R.dimen.Normal100)
                ),
                textAlign = TextAlign.Justify
            )
            if (showRetryButton) {
                TextButton(
                    onClick = onClickRetry,
                    border = BorderStroke(
                        dimensionResource(id = SharedRes.dimen.OneDp),
                        MaterialTheme.colorScheme.surface
                    )
                ) {
                    Text(
                        stringResource(id = SharedRes.strings.til_try_again),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Composable
@Preview(name = "Light Theme", showBackground = true)
fun CustomLottieMessagePreview() {
    CustomLottieMessage(
        lottie = R.raw.animation_error,
        title = stringResource(R.string.til_close),
        message = stringResource(R.string.desc_error)
    )
}
