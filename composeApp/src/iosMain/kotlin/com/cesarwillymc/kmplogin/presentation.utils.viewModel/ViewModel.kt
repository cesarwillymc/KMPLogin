package com.cesarwillymc.kmplogin.presentation.utils.viewModel

import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual open class ViewModel : InstanceKeeper.Instance, CoroutineScope {
    actual override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    override fun onDestroy() {
        coroutineContext.cancel()
    }

    actual val viewModelScope: CoroutineScope
        get() = CoroutineScope(coroutineContext)
}