package com.cesarwillymc.kmplogin.presentation.screens.home.viewmodel

import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.presentation.screens.home.state.DetailSurveyUiState
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.component.KoinComponent

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

class DetailSurveyViewModel : ViewModel(), KoinComponent {
    /** Variables */
    val detailUiState get() = _detailUiState
    private val _detailUiState = MutableStateFlow(DetailSurveyUiState())
    /** Behaviors */
    private fun onLoadArgument(survey: SurveyItem) {
        _detailUiState.update { update -> update.copy(data = survey) }
    }
}
