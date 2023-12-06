package com.cesarwillymc.kmplogin.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.ChildStack
import com.cesarwillymc.kmplogin.presentation.screens.auth.ForgotScreen
import com.cesarwillymc.kmplogin.presentation.screens.auth.LoginScreen
import com.cesarwillymc.kmplogin.presentation.screens.home.DetailSurveyScreen
import com.cesarwillymc.kmplogin.presentation.screens.home.HomeScreen
import com.cesarwillymc.kmplogin.presentation.screens.splash.SplashScreen
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.LocalComponentContext

@Composable
fun NavigationGraph(
    childStack: ChildStack<RootComponent.Configuration, RootComponent.Child>
) {
    Children(
        stack = childStack,
        animation = stackAnimation(slide())
    ) { child ->
        CompositionLocalProvider(LocalComponentContext provides child.instance.componentContext) {
            when (val instance = child.instance) {
                is RootComponent.Child.Splash -> SplashScreen(
                    event = instance.component
                )

                is RootComponent.Child.SignIn -> LoginScreen(
                    event = instance.component
                )

                is RootComponent.Child.ForgotPassword -> ForgotScreen(
                    event = instance.component
                )

                is RootComponent.Child.Home -> HomeScreen(
                    event = instance.component
                )

                is RootComponent.Child.Detail -> DetailSurveyScreen(
                    event = instance.component
                )
            }
        }

    }
}
