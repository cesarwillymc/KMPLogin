package com.cesarwillymc.kmplogin.presentation.navigation.event

import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem

/**
 * Created by Cesar Canaza on 12/4/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
 interface HomeNavEvent {
   fun navigateToDetail(surveyItem: SurveyItem)
    fun navigateToSignIn()
 }