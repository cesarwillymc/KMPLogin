package com.cesarwillymc.kmplogin.presentation.navigation.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import com.cesarwillymc.kmplogin.presentation.navigation.event.SplashEvent

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@OptIn(ExperimentalDecomposeApi::class)
class SplashComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootComponent.Configuration>
) : ComponentContext by componentContext, SplashEvent {

    override fun navigateToHome() {
        navigation.pushNew(RootComponent.Configuration.Home)
    }

    override fun navigateToSignIn() {
        navigation.pushNew(RootComponent.Configuration.SignIn)
    }
}