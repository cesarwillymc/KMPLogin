package com.cesarwillymc.kmplogin.presentation.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.composables.VerticalCenteredLayoutWithFullHeightFirstItem
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.ImageType
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColor
import com.cesarwillymc.kmplogin.presentation.theme.TextColorOpacity
import com.cesarwillymc.kmplogin.presentation.theme.Typography
import com.cesarwillymc.kmplogin.presentation.theme.getImageSize
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.presentation.utils.rememberResponsive
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun HomeDrawerContent(
    onLogoutClick: () -> Unit
) {
    val responsive = rememberResponsive()
    Column(
        verticalArrangement = Arrangement.spacedBy( DimensionManager.getPadding(PaddingType.Medium)),
        modifier = Modifier.padding(
            DimensionManager.getPadding(PaddingType.Medium)
        )
    ) {

            VerticalCenteredLayoutWithFullHeightFirstItem(modifier = Modifier.wrapContentHeight()) {
                Text(
                    stringResource(SharedRes.strings.desc_description),
                    style = Typography.titleLarge,
                    color = TextColor

                )
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                ) {
                    Image(
                        painter = painterResource(SharedRes.images.profile),
                        contentDescription = stringResource(SharedRes.strings.lbl_profile),
                        modifier = Modifier.size(DimensionManager.getImageSize(ImageType.IconMedium)),
                        contentScale = ContentScale.Crop
                    )
                }
            }

        Divider()
        Text(
            stringResource(SharedRes.strings.lbl_logout),
            style = Typography.bodyMedium,
            color = TextColorOpacity,
            modifier = Modifier.clickable { onLogoutClick() }
        )
    }
}
