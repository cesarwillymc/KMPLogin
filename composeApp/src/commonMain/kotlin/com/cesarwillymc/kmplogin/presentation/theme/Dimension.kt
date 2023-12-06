package com.cesarwillymc.kmplogin.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import org.jetbrains.skia.Image

/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
expect object DimensionManager

@Composable
expect fun DimensionManager.getTextSize(textType: TextType): TextUnit
@Composable
expect fun DimensionManager.getPadding(paddingType: PaddingType): Dp
@Composable
expect fun DimensionManager.getImageSize(imageType: ImageType): Dp
@Composable
expect fun DimensionManager.getOtherSize(otherType: OtherSizeType): Dp

enum class TextType {
    Title,
    Subtitle,
    Body,
    Caption,
    ExtraBig // Add any additional text types as needed
}

enum class PaddingType {
    Small,
    Medium,
    Large,
    ExtraLarge // Add any additional padding types as needed
}

enum class ImageType {
    IconSmall,
    IconMedium,
    IconLarge, IconExtraLarge, ImageSmall, ImageMedium, ImageLarge, ImageExtraLarge
}

enum class OtherSizeType {
    MiniElevation,
    NormalElevation,
    HighElevation
}