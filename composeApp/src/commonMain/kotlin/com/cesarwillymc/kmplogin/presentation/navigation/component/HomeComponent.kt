package com.cesarwillymc.kmplogin.presentation.navigation.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import com.cesarwillymc.kmplogin.presentation.navigation.event.HomeEvent

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class HomeComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootComponent.Configuration>
) : ComponentContext by componentContext, HomeEvent {
    @OptIn(ExperimentalDecomposeApi::class)
    override fun navigateToDetail(surveyItem: SurveyItem) {
        navigation.pushNew(configuration = RootComponent.Configuration.Detail(surveyItem))
    }

    override fun navigateToSignIn() {
        navigation.push(configuration = RootComponent.Configuration.SignIn)
    }
}