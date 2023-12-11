package com.cesarwillymc.kmplogin.presentation.navigation.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.router.stack.replaceAll
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import com.cesarwillymc.kmplogin.presentation.navigation.event.HomeNavEvent

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class HomeComponent(
    componentContext: ComponentContext,
    private val navigation: StackNavigation<RootComponent.Configuration>
) : ComponentContext by componentContext, HomeNavEvent {

    override fun navigateToDetail(surveyItem: SurveyItem) {
        navigation.pushNew(configuration = RootComponent.Configuration.Detail(surveyItem))
    }

    override fun navigateToSignIn() {
        navigation.replaceAll(RootComponent.Configuration.SignIn)
    }
}