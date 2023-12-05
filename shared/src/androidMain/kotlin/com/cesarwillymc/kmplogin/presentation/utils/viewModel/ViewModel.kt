package com.cesarwillymc.kmplogin.presentation.utils.viewModel

import androidx.compose.ui.platform.AndroidUiDispatcher
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
actual open class ViewModel : InstanceKeeper.Instance, CoroutineScope {
    actual override val coroutineContext: CoroutineContext = AndroidUiDispatcher.Main + SupervisorJob()
    override fun onDestroy() { coroutineContext.cancel() }
}