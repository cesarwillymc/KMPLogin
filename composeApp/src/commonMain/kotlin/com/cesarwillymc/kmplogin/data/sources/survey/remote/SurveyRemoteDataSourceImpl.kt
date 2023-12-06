package com.cesarwillymc.kmplogin.data.sources.survey.remote

import com.apollographql.apollo3.ApolloClient
import com.cesarwillymc.GetSurveysQuery
import com.cesarwillymc.kmplogin.data.settings.network.util.BaseRemoteDataSource
import com.cesarwillymc.kmplogin.util.constants.THREE
import com.cesarwillymc.kmplogin.util.state.Result
import javax.inject.Inject

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyRemoteDataSourceImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : BaseRemoteDataSource(), SurveyRemoteDataSource {
    override suspend fun getSurveys(): Result<GetSurveysQuery.Data?> {
        return getResult {
            apolloClient.query(GetSurveysQuery(THREE)).execute().data
        }
    }
}
