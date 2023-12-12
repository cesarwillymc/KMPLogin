package com.cesarwillymc.kmplogin.data.survey.mapper

import com.cesarwilly.GetSurveysQuery
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList


/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
class SurveyMapperImpl : SurveyMapper {
    override fun dataSurveyToDomain(data: GetSurveysQuery.Data?): SurveyList {
        return data?.surveys?.let {
            SurveyList(
                hasNext = it.pageInfo.hasNextPage,
                list = it.edges.map { item ->
                    SurveyItem(
                        id = item.node.id,
                        title = item.node.title,
                        description = item.node.description,
                        coverImageUrl = item.node.coverImageUrl
                    )
                }
            )
        } ?: SurveyList(hasNext = false, listOf())
    }
}
