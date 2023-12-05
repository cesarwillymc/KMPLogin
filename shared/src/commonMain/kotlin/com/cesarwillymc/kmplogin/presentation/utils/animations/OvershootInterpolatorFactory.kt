package com.cesarwillymc.kmplogin.presentation.utils.animations

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
expect class OvershootInterpolatorFactory(amplitude: Float) {
    fun getInterpolation(input: Float): Float
}