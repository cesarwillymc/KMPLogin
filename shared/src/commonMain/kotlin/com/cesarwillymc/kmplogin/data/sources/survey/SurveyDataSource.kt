package com.cesarwillymc.kmplogin.data.sources.survey

import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList
import com.cesarwillymc.kmplogin.util.state.Result

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface SurveyDataSource {
    suspend fun getSurveys(): Result<SurveyList>
}
