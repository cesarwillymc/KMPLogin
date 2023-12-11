package com.cesarwillymc.kmplogin.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.cesarwillymc.kmplogin.util.constants.ONE_F

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
