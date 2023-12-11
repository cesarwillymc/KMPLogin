package com.cesarwillymc.kmplogin.presentation.utils.kotlinExtension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

/**
 * Created by Cesar Canaza on 12/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

@Composable
inline fun <E> Channel<E>.getStateUi(initialValue: E? = null): State<E?> {
    return this.receiveAsFlow().collectAsState(initialValue)
}