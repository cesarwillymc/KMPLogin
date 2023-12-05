package com.cesarwillymc.kmplogin.presentation.utils.animations

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
import platform.QuartzCore.CAMediaTimingFunction

actual class OvershootInterpolatorFactory actual constructor(private val amplitude: Float) {
    actual fun getInterpolation(input: Float): Float {
        // Implement overshoot-like behavior for iOS
        // This could involve working with cubic bezier curves in Core Animation
        // You may need to adjust this implementation based on your specific needs
        // For simplicity, this example just returns the input as-is

        return input
    }
}