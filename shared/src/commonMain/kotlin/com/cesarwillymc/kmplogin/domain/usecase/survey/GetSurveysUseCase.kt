package com.cesarwillymc.kmplogin.domain.usecase.survey

import com.cesarwillymc.kmplogin.data.sources.survey.SurveyDataSource
import com.cesarwillymc.kmplogin.di.IoDispatcher
import com.cesarwillymc.kmplogin.domain.base.SuspendUseCase
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList
import com.cesarwillymc.kmplogin.util.state.Result
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class GetSurveysUseCase @Inject constructor(
    private val repository: SurveyDataSource,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, SurveyList>(
    dispatcher
) {
    override suspend fun execute(parameters: Unit): Result<SurveyList> {
        return repository.getSurveys()
    }
}
