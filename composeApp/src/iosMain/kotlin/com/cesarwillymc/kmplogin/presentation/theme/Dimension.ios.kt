package com.cesarwillymc.kmplogin.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual object DimensionManager

@Composable
actual fun DimensionManager.getPadding(paddingType: PaddingType): Dp {
    return when (paddingType) {
        PaddingType.Small -> 10.dp
        PaddingType.Medium -> 12.dp
        PaddingType.Large -> 16.dp
        PaddingType.ExtraLarge -> 24.dp
    }
}

@Composable
actual fun DimensionManager.getImageSize(imageType: ImageType): Dp {
    return when (imageType) {
        ImageType.IconSmall -> 25.dp
        ImageType.IconMedium -> 40.dp
        ImageType.IconLarge -> 48.dp
        ImageType.IconExtraLarge -> 55.dp
        ImageType.ImageSmall -> 80.dp
        ImageType.ImageMedium -> 70.dp
        ImageType.ImageLarge -> 260.dp
        ImageType.ImageExtraLarge -> 210.dp
    }
}

@Composable
actual fun DimensionManager.getOtherSize(otherType: OtherSizeType): Dp {
    return when (otherType) {
        OtherSizeType.MiniElevation -> 4.dp
        OtherSizeType.NormalElevation -> 8.dp
        OtherSizeType.HighElevation -> 10.dp
        OtherSizeType.TextFieldHeight -> 60.dp
    }
}

@Composable
actual fun DimensionManager.getTextSize(textType: TextType): TextUnit {
    return when (textType) {
        TextType.Title -> 28.sp
        TextType.Subtitle -> 20.sp
        TextType.Body -> 16.sp
        TextType.Caption -> 10.sp
        TextType.ExtraBig -> 40.sp
    }
}