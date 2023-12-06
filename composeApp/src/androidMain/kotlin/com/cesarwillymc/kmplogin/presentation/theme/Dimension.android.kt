package com.cesarwillymc.kmplogin.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.cesarwillymc.kmplogin.R


/**
 * Created by Cesar Canaza on 12/5/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual object DimensionManager

@Composable
actual fun DimensionManager.getPadding(paddingType: PaddingType): Dp {
    return when(paddingType){
        PaddingType.Small -> dimensionResource(id =  R.dimen.Small120)
        PaddingType.Medium -> dimensionResource(id = R.dimen.Small150)
        PaddingType.Large -> dimensionResource(id =  R.dimen.Normal100)
        PaddingType.ExtraLarge -> dimensionResource(id =  R.dimen.Normal150)
    }
}
@Composable
actual fun DimensionManager.getImageSize(imageType: ImageType): Dp {
    return when(imageType){
        ImageType.IconSmall -> dimensionResource(id =  R.dimen.ImageIconSmall)
        ImageType.IconMedium -> dimensionResource(id =  R.dimen.ImageIcon)
        ImageType.IconLarge -> dimensionResource(id =  R.dimen.ImageIconLarge)
        ImageType.IconExtraLarge -> dimensionResource(id =  R.dimen.ImageIconExtraLarge)
        ImageType.ImageSmall -> dimensionResource(id =  R.dimen.ImageMini)
        ImageType.ImageMedium -> dimensionResource(id =  R.dimen.ImageMedium)
        ImageType.ImageLarge -> dimensionResource(id =  R.dimen.ImageSemiLarge)
        ImageType.ImageExtraLarge -> dimensionResource(id =  R.dimen.ImageLarge)
    }
}
@Composable
actual fun DimensionManager.getOtherSize(otherType: OtherSizeType): Dp {
    return when(otherType){
        OtherSizeType.MiniElevation -> dimensionResource(id =  R.dimen.MiniElevation)
        OtherSizeType.NormalElevation -> dimensionResource(id =  R.dimen.NormalElevation)
        OtherSizeType.HighElevation -> dimensionResource(id =  R.dimen.HighElevation)
    }
}
@Composable
actual fun DimensionManager.getTextSize(textType: TextType): TextUnit {
    return when(textType){
        TextType.Title -> 28.sp
        TextType.Subtitle -> 20.sp
        TextType.Body -> 16.sp
        TextType.Caption -> 10.sp
        TextType.ExtraBig -> 40.sp
    }
}