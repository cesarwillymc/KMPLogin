package com.cesarwillymc.kmplogin.presentation.screens.auth.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.ImageType
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.getImageSize
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.presentation.utils.rememberResponsive
import com.cesarwillymc.kmplogin.util.constants.FRACTION_20
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun AuthScaffold(
    isIconsTopEnabled: Boolean = false,
    onNavigateUp: () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    val responsive = rememberResponsive()
    Scaffold { paddingValues ->

        Image(
            painter = painterResource(SharedRes.images.img_overlay),
            contentDescription = stringResource(SharedRes.strings.lbl_onbackground),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(paddingValues = paddingValues)
                .padding(DimensionManager.getPadding(PaddingType.Medium))
                .fillMaxSize()
        ) {
            if (isIconsTopEnabled) {
                Icon(
                    painter = painterResource(SharedRes.images.arrow_ios_back),
                    contentDescription = stringResource(SharedRes.strings.desc_back),
                    modifier = Modifier
                        .clickable(onClick = onNavigateUp)
                        .align(Alignment.TopStart)
                        .size(DimensionManager.getImageSize(ImageType.IconSmall)),
                    tint = Color.White
                )
                Box(modifier = Modifier.align(Alignment.TopEnd)) {
                    trailingIcon()
                }
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    DimensionManager.getPadding(
                        PaddingType.Medium
                    )
                )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(SharedRes.images.logo),
                        contentDescription = "Icon logo",
                        modifier = Modifier.align(Alignment.Center).padding(
                            top = responsive.heightR(
                                FRACTION_20
                            )
                        )
                    )
                }
                Spacer(modifier = Modifier.size(DimensionManager.getPadding(PaddingType.Large)))
                content()
            }
        }
    }
}

