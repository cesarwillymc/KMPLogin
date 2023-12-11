package com.cesarwillymc.kmplogin.presentation.utils.viewModel

import androidx.compose.ui.platform.AndroidUiDispatcher
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual open class ViewModel : InstanceKeeper.Instance, CoroutineScope {
    actual override val coroutineContext: CoroutineContext =
        AndroidUiDispatcher.Main + SupervisorJob()

    override fun onDestroy() {
        coroutineContext.cancel()
    }

    actual val viewModelScope: CoroutineScope
        get() = CoroutineScope(coroutineContext)


    actual val event: Channel<BaseEvent?> = Channel(Channel.BUFFERED)
}