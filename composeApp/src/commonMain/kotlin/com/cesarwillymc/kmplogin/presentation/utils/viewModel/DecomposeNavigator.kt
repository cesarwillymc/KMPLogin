package com.cesarwillymc.kmplogin.presentation.utils.viewModel

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.arkivanov.decompose.ComponentContext

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
val LocalComponentContext: ProvidableCompositionLocal<ComponentContext> =
    staticCompositionLocalOf { error("Root component context was not provided") }