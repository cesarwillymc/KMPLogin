package com.cesarwillymc.kmplogin.presentation.utils.animations

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual class OvershootInterpolatorFactory actual constructor(private val amplitude: Float) {
    actual fun getInterpolation(input: Float): Float {
        return android.view.animation.OvershootInterpolator(amplitude).getInterpolation(input)
    }
}