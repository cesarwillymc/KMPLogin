package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.cesarwillymc.kmplogin.presentation.utils.kotlinExtension.shimmerLoadingAnimation

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun TextShimmer(
    modifier: Modifier
) {
    Box(
        modifier = modifier.clip(CircleShape).shimmerLoadingAnimation()

    ) {
    }
}

