package com.cesarwillymc.kmplogin.presentation.utils.lottie

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.ImageType
import com.cesarwillymc.kmplogin.presentation.theme.OtherSizeType
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.getImageSize
import com.cesarwillymc.kmplogin.presentation.theme.getOtherSize
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual object LottieHandler {
    @Composable
    actual fun loadingFile() {
        CircularProgressIndicator(
            modifier = Modifier.size(DimensionManager.getImageSize(ImageType.ImageMedium)),
            color = Color.White,
            trackColor = Color.Gray,
            strokeWidth = DimensionManager.getPadding(PaddingType.Large)
        )
    }

    @Composable
    actual fun errorFile() {
        Image(
            painterResource(SharedRes.images.animation_error),
            contentDescription = "Image Error",
            modifier = Modifier.size(DimensionManager.getImageSize(ImageType.ImageExtraLarge)),
            contentScale = ContentScale.FillBounds
        )
    }
}
