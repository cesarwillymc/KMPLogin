package com.cesarwillymc.kmplogin.presentation.screens.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cesarwillymc.kmplogin.presentation.composables.TextShimmer
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.presentation.utils.rememberResponsive
import com.cesarwillymc.kmplogin.util.constants.FRACTION_10
import com.cesarwillymc.kmplogin.util.constants.FRACTION_30
import com.cesarwillymc.kmplogin.util.constants.FRACTION_40
import com.cesarwillymc.kmplogin.util.constants.FRACTION_50
import com.cesarwillymc.kmplogin.util.constants.FRACTION_70
import com.cesarwillymc.kmplogin.util.constants.FRACTION_90

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun HomeContentLoading() {
    val responsive = rememberResponsive()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color.Black)
            .padding( DimensionManager.getPadding(PaddingType.Medium))
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(DimensionManager.getPadding(PaddingType.Small))) {
                TextShimmer(
                    modifier = Modifier.size(
                        width = responsive.withR(FRACTION_50),
                        height =  DimensionManager.getPadding(PaddingType.Medium)
                    )
                )
                TextShimmer(
                    modifier = Modifier.size(
                        width = responsive.withR(FRACTION_30),
                        height =  DimensionManager.getPadding(PaddingType.Medium)
                    )
                )
            }
            Spacer(modifier = Modifier.size( DimensionManager.getPadding(PaddingType.Small)))

            TextShimmer(
                modifier = Modifier.size(DimensionManager.getPadding(PaddingType.Large))
            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(
                DimensionManager.getPadding(PaddingType.Medium)
            )
        ) {
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_10),
                    height =  DimensionManager.getPadding(PaddingType.Medium)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_70),
                    height =  DimensionManager.getPadding(PaddingType.Medium)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_40),
                    height =  DimensionManager.getPadding(PaddingType.Medium)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_90),
                    height =  DimensionManager.getPadding(PaddingType.Medium)
                )
            )
            TextShimmer(
                modifier = Modifier.size(
                    width = responsive.withR(FRACTION_30),
                    height = DimensionManager.getPadding(PaddingType.Medium)
                )
            )
        }
    }
}
