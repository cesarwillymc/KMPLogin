package com.cesarwillymc.kmplogin.data.survey.remote

import com.apollographql.apollo3.ApolloClient
import com.cesarwilly.GetSurveysQuery
import com.cesarwillymc.kmplogin.data.util.BaseRemoteDataSource
import com.cesarwillymc.kmplogin.util.constants.THREE

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRemoteDataSourceImpl (
    private val apolloClient: ApolloClient
) : BaseRemoteDataSource(), SurveyRemoteDataSource {
    override suspend fun getSurveys(): Result<GetSurveysQuery.Data?> {
        return getResult {
            apolloClient.query(GetSurveysQuery(THREE)).execute().data
        }
    }
}
