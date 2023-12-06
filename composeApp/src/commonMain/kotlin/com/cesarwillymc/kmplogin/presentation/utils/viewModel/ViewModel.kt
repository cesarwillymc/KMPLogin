package com.cesarwillymc.kmplogin.presentation.utils.viewModel

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
expect open class ViewModel() : InstanceKeeper.Instance, CoroutineScope {
    override val coroutineContext: CoroutineContext
    val viewModelScope: CoroutineScope
}