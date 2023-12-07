package com.cesarwillymc.kmplogin.data.sources.survey.remote

import com.cesarwilly.GetSurveysQuery

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
interface SurveyRemoteDataSource {
    suspend fun getSurveys(): Result<GetSurveysQuery.Data?>
}
