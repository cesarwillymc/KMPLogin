package com.cesarwillymc.kmplogin.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.util.constants.ONE_F
import com.cesarwillymc.kmplogin.util.constants.ZERO

/**
 * Created by cesarwillymamanicanaza on 17/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Composable
expect fun rememberResponsive(): Responsive

expect class Responsive {

    /** get size screen by size **/
    fun withR(percent: Float = ONE_F):Dp
    fun heightR(percent: Float = ONE_F):Dp
}

/*
expect class Responsive(private val configuration: DpSize) {
    private var width: Dp = ZERO.dp
    private var height: Dp = ZERO.dp

    init {
        getDimension()
    }

    private fun getDimension() {
        width = configuration.width
        height = configuration.height
    }

    /** get size screen by size **/
    fun withR(percent: Float = ONE_F) = (width * percent)
    fun heightR(percent: Float = ONE_F) = (height * percent)
}

 */