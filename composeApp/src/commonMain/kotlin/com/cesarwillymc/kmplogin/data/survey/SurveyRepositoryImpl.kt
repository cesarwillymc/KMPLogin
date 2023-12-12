package com.cesarwillymc.kmplogin.data.survey

import com.cesarwillymc.kmplogin.data.survey.mapper.SurveyMapper
import com.cesarwillymc.kmplogin.data.survey.remote.SurveyRemoteDataSource
import com.cesarwillymc.kmplogin.domain.repository.SurveyRepository
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRepositoryImpl(
    private val surveyRemoteDataSource: SurveyRemoteDataSource,
    private val mapper: SurveyMapper
) : SurveyRepository {
    override suspend fun getSurveys(): Result<SurveyList> {
        return surveyRemoteDataSource.getSurveys().map(mapper::dataSurveyToDomain)
    }
}
