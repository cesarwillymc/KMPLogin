package com.cesarwillymc.kmplogin.presentation.screens.home.state

import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

sealed class HomeUiState{
    data object Loading: HomeUiState()
    data class Success(val data: SurveyList?): HomeUiState()
    data object Error: HomeUiState()
}
