package com.cesarwillymc.kmplogin.domain.usecase.survey

import com.cesarwillymc.kmplogin.domain.repository.SurveyRepository
import com.cesarwillymc.kmplogin.domain.base.SuspendUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList
import kotlinx.coroutines.CoroutineDispatcher

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class GetSurveysUseCase (
    private val repository: SurveyRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, SurveyList>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<SurveyList> {
        return repository.getSurveys()
    }
}
