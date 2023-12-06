package com.cesarwillymc.kmplogin.presentation.navigation.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.pushNew
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import com.cesarwillymc.kmplogin.presentation.navigation.event.SignInEvent

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@OptIn(ExperimentalDecomposeApi::class)
class SignInComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootComponent.Configuration>
) : ComponentContext by componentContext, SignInEvent {

    override fun navigateToHome() {
        navigation.pushNew(RootComponent.Configuration.Home)
    }

    override fun navigateToForgotPassword() {
        navigation.pushNew(RootComponent.Configuration.ForgotPassword)
    }
}