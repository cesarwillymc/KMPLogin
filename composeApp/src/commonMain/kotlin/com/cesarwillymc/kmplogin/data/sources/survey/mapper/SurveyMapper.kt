package com.cesarwillymc.kmplogin.data.sources.survey.mapper

import com.cesarwillymc.GetSurveysQuery
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface SurveyMapper {
    fun dataSurveyToDomain(data: GetSurveysQuery.Data?): SurveyList
}
