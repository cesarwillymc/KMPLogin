package com.cesarwillymc.kmplogin.presentation.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.presentation.navigation.component.DetailComponent
import com.cesarwillymc.kmplogin.presentation.navigation.component.ForgotPasswordComponent
import com.cesarwillymc.kmplogin.presentation.navigation.component.HomeComponent
import com.cesarwillymc.kmplogin.presentation.navigation.component.SignInComponent
import com.cesarwillymc.kmplogin.presentation.navigation.component.SplashComponent
import kotlinx.serialization.Serializable

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class RootComponent(componentContext: ComponentContext) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Splash,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.Splash -> Child.Splash(
                SplashComponent(
                    componentContext = context,
                    navigation = navigation
                )
            )

            Configuration.SignIn -> Child.SignIn(
                SignInComponent(context, navigation)
            )

            Configuration.ForgotPassword -> Child.ForgotPassword(
                ForgotPasswordComponent(context, navigation)
            )

            Configuration.Home -> Child.Home(
                HomeComponent(context, navigation)
            )

            is Configuration.Detail -> Child.Detail(
                DetailComponent(config.survey, context, navigation)
            )

        }
    }

    sealed class Child(val componentContext: ComponentContext) {
        data class Splash(val component: SplashComponent) : Child(component)
        data class SignIn(val component: SignInComponent) : Child(component)
        data class ForgotPassword(val component: ForgotPasswordComponent) : Child(component)
        data class Home(val component: HomeComponent) : Child(component)
        data class Detail(val component: DetailComponent) : Child(component)
    }

    @Serializable
    sealed class Configuration {
        data object Splash : Configuration()
        data object SignIn : Configuration()
        data object ForgotPassword : Configuration()
        data object Home : Configuration()
        data class Detail(val survey: SurveyItem) : Configuration()

    }
}