package com.cesarwillymc.kmplogin.data.sources.survey

import com.cesarwillymc.kmplogin.data.sources.survey.mapper.SurveyMapper
import com.cesarwillymc.kmplogin.data.sources.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList
import com.cesarwillymc.kmplogin.util.state.Result
import com.cesarwillymc.kmplogin.util.state.map
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRepository @Inject constructor(
    private val surveyRemoteDataSource: SurveyRemoteDataSource,
    private val mapper: SurveyMapper
) : SurveyDataSource {
    override suspend fun getSurveys(): Result<SurveyList> {
        return surveyRemoteDataSource.getSurveys().map(mapper::dataSurveyToDomain)
    }
}
