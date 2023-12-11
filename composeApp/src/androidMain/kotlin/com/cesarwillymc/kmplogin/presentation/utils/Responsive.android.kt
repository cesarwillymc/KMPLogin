package com.cesarwillymc.kmplogin.presentation.utils

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.util.constants.ZERO

/**
 * Created by cesarwillymamanicanaza on 17/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Composable
actual fun rememberResponsive(): Responsive {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    return remember { Responsive(configuration, density) }
}

actual class Responsive(private val configuration: Configuration, private val density: Density) {
    private var height = ZERO
    private var width = ZERO

    init {
        getDimension()
    }

    private fun getDimension() {
        height = configuration.screenHeightDp
        width = configuration.screenWidthDp
    }

    /** get size screen by size **/
    actual fun withR(percent: Float): Dp {
        return with(density){(width * percent).toDp()}
    }

    actual fun heightR(percent: Float): Dp {
        return (height * percent).toInt().dp
    }

}