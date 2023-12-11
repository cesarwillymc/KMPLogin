package com.cesarwillymc.kmplogin.presentation.utils.viewModel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.arkivanov.essenty.statekeeper.StateKeeper
import kotlin.reflect.KClass

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
// Save the state of the viewModel for persist the information in configuration changes of the device
@Suppress("UNCHECKED_CAST") // ViewModels must be Instances
@Composable
fun <T : ViewModel> rememberViewModel(
    viewModelClass: KClass<T>,
    block: @DisallowComposableCalls (savedState: SavedStateHandle) -> T,
): T {
    val component: ComponentContext = LocalComponentContext.current
    val stateKeeper: StateKeeper = component.stateKeeper
    val instanceKeeper: InstanceKeeper = component.instanceKeeper

    val packageName: String =
        requireNotNull(viewModelClass.simpleName) { "Unable to retain anonymous instance of $viewModelClass" }
    val viewModelKey = "$packageName.viewModel"
    val stateKey = "$packageName.savedState"

    val (viewModel, savedState) = remember(viewModelClass) {
        val savedState: SavedStateHandle = instanceKeeper
            .getOrCreate(stateKey) {
                SavedStateHandle(
                    stateKeeper.consume(
                        stateKey,
                        SavedState::class,
                    ),
                )
            }
        var viewModel: T? = instanceKeeper.get(viewModelKey) as T?
        if (viewModel == null) {
            viewModel = block(savedState)
            instanceKeeper.put(viewModelKey, viewModel)
        }
        viewModel to savedState
    }

    LaunchedEffect(Unit) {
        if (!stateKeeper.isRegistered(stateKey)) {
            stateKeeper.register(stateKey) { savedState.value }
        }
    }

    return viewModel
}