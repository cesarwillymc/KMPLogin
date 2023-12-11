package com.cesarwillymc.kmplogin.presentation.screens.home.state

import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
data class DetailSurveyUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
    val data: SurveyItem? = null
)