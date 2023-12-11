package com.cesarwillymc.kmplogin.presentation.utils.kotlinExtension

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.cesarwillymc.kmplogin.util.constants.DELAY_1000
import com.cesarwillymc.kmplogin.util.constants.FRACTION_30
import com.cesarwillymc.kmplogin.util.constants.FRACTION_50
import com.cesarwillymc.kmplogin.util.constants.ONE_F
import com.cesarwillymc.kmplogin.util.constants.ZERO_F

/**
 * Created by Cesar Canaza on 12/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

fun Modifier.shimmerLoadingAnimation(
    widthOfShadowBrush: Int = 500,
    angleOfAxisY: Float = 270f,
    durationMillis: Int = DELAY_1000.toInt(),
): Modifier {
    return composed {

        val shimmerColors = listOf(
            Color.White.copy(alpha = FRACTION_30),
            Color.White.copy(alpha = FRACTION_50),
            Color.White.copy(alpha = ONE_F),
            Color.White.copy(alpha = FRACTION_50),
            Color.White.copy(alpha = FRACTION_30),
        )

        val transition = rememberInfiniteTransition()

        val translateAnimation = transition.animateFloat(
            initialValue = ZERO_F,
            targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Restart,
            )
        )

        this.background(
            brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = ZERO_F),
                end = Offset(x = translateAnimation.value, y = angleOfAxisY),
            ),
        )
    }
}