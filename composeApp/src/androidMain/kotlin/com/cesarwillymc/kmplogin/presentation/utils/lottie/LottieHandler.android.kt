package com.cesarwillymc.kmplogin.presentation.utils.lottie

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.cesarwillymc.kmplogin.R

/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual object LottieHandler{
    @Composable
    actual fun loadingFile() {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(dimensionResource(id = R.dimen.ImageSemiLarge))
        )
    }
    @Composable
    actual fun errorFile() {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_error))
        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(dimensionResource(id = R.dimen.ImageSemiLarge))
        )
    }
}