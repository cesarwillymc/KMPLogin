package com.cesarwillymc.kmplogin.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.util.constants.ZERO

/**
 * Created by cesarwillymamanicanaza on 17/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun rememberResponsive(): Responsive {
    val screenSize = LocalWindowInfo.current.containerSize
    val density = LocalDensity.current
    return remember { Responsive(screenSize,density) }

}

actual class Responsive(containerSize: IntSize, val density: Density) {
    private var width = ZERO
    private var height = ZERO

    /** get size screen by size **/
    init {
        width = containerSize.width
        height = containerSize.height
    }

    actual fun withR(percent: Float): Dp {
        return with(density){ (width * percent).toDp() }
    }

    actual fun heightR(percent: Float): Dp {
        return with(density){(height * percent).toDp()}
    }

}