package com.cesarwillymc.kmplogin.data.survey.mapper

import com.cesarwilly.GetSurveysQuery
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
