package com.cesarwillymc.kmplogin.presentation.screens.splash

import com.cesarwillymc.kmplogin.domain.usecase.auth.GetLoggedStateUseCase
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.ViewModel
import com.cesarwillymc.kmplogin.util.extension.orEmpty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

class SplashViewModel : ViewModel(), KoinComponent {
    /** Dependency injection */
    private val isLogged = get<GetLoggedStateUseCase>()

    /** Variables */
    private val _navigateHome = MutableStateFlow<Boolean?>(null)
    val navigateHome get() = _navigateHome

    init {
        loadFirstRoute()
    }
    /** Behaviors */
    fun loadFirstRoute() {
        viewModelScope.launch {
            isLogged(Unit).let { result ->
                if (result.isSuccess && result.getOrNull().orEmpty()) {
                    _navigateHome.update { true }
                } else {
                    _navigateHome.update { false }
                }
            }
        }
    }
}
