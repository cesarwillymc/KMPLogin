package com.cesarwillymc.kmplogin.presentation.theme

import androidx.compose.ui.unit.Dp
import org.jetbrains.skia.Image

/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
expect class DimensionManager()

expect fun DimensionManager.getTextSize(textType: TextType): Float
expect fun DimensionManager.getPadding(paddingType: PaddingType): Int
expect fun DimensionManager.getImageSize(imageType: ImageType): Int
expect fun DimensionManager.getOtherSize(otherType: OtherSizeType): Int

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
    IconSmall,
    IconMedium,
    IconLarge, IconExtraLarge, ImageSmall, ImageMedium, ImageLarge, ImageExtraLarge
}

expect object Dimension {
    var margin: Dp
    var
            <!-- Size values in dp-->
    <dimen name="ZeroDp">0dp</dimen>
    <dimen name="OneDp">1dp</dimen>
    <dimen name="TwoDp">2dp</dimen>
    <dimen name="ThreeDp">3dp</dimen>
    <dimen name="FiveDp">5dp</dimen>
    <dimen name="SixDp">6dp</dimen>
    <dimen name="EigthDp">8dp</dimen>

    <!-- Elevation values in dp -->
    <dimen name="MiniElevation">3dp</dimen>
    <dimen name="NormalElevation">5dp</dimen>
    <dimen name="HighElevation">8dp</dimen>

    <!-- Small sizes in dp -->
    <dimen name="Small50">4dp</dimen>
    <dimen name="Small100">8dp</dimen>
    <dimen name="Small120">10dp</dimen>
    <dimen name="Small150">12dp</dimen>
    <dimen name="Small175">14dp</dimen>

    <!-- Normal sizes in dp -->
    <dimen name="Normal100">16dp</dimen>
    <dimen name="Normal125">20dp</dimen>
    <dimen name="Normal150">24dp</dimen>
    <dimen name="Normal162">26dp</dimen>
    <dimen name="Normal175">28dp</dimen>

    <!-- Large sizes in dp -->
    <dimen name="Large100">32dp</dimen>
    <dimen name="Large125">40dp</dimen>
    <dimen name="Large150">48dp</dimen>
    <dimen name="Large175">56dp</dimen>

    <!-- Text sizes in sp -->
    <dimen name="Text4SP">4sp</dimen>
    <dimen name="TextSuperMini">5sp</dimen>
    <dimen name="TextRibbon">6sp</dimen>
    <dimen name="TextExtraMini">8sp</dimen>
    <dimen name="TextMini">10sp</dimen>
    <dimen name="Text_11sp">11sp</dimen>
    <dimen name="TextSmall">12sp</dimen>
    <dimen name="TextMedium">14sp</dimen>
    <dimen name="TextNormal">16sp</dimen>
    <dimen name="TextLarge">20sp</dimen>
    <dimen name="TextExtraLarge">28sp</dimen>

    <!-- Line height values in sp -->
    <dimen name="HeighLine">0sp</dimen>
    <dimen name="HeighMedium">30sp</dimen>
    <dimen name="HeighNormal">60sp</dimen>

    <!-- Image dimensions in dp -->
    <dimen name="ImageLarge">260dp</dimen>
    <dimen name="ImageSemiLarge">210dp</dimen>
    <dimen name="ImageIcon">25dp</dimen>
    <dimen name="ImageIconSelected">30dp</dimen>
    <dimen name="ImageSuperMini">40dp</dimen>
    <dimen name="ImageMini">80dp</dimen>
    <dimen name="ImageMedium">70dp</dimen>
    <dimen name="ImageNormal">110dp</dimen>
    <dimen name="ImageEmptyView">60dp</dimen>

    <dimen name="BottomBarCellHeight">46dp</dimen>
}