package com.cesarwillymc.kmplogin.presentation.screens.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyList
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.util.constants.FRACTION_30
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    surveyList: SurveyList,
    navigateToDetail: (SurveyItem) -> Unit,
    openDrawer: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val pagerState = rememberPagerState(pageCount = {
            surveyList.list.size
        })
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                KamelImage(
                    asyncPainterResource(surveyList.list[page].coverImageUrl),
                    contentDescription = "ImageCover",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black.copy(alpha = FRACTION_30))
                )
            }
        }
        SurveyContentPager(
            surveyItem = surveyList.list[pagerState.currentPage],
            currentItem = pagerState.currentPage,
            totalItems = surveyList.list.size,
            modifier = Modifier
                .align(
                    Alignment.BottomStart
                )
                .padding( DimensionManager.getPadding(PaddingType.Medium)),
            navigateDetail = navigateToDetail
        )
        ProfileCard(openDrawer = openDrawer)
    }
}
