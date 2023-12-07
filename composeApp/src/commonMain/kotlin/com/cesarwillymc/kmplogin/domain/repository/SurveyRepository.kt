package com.cesarwillymc.kmplogin.domain.repository

import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface SurveyRepository {
    suspend fun getSurveys(): Result<SurveyList>
}
