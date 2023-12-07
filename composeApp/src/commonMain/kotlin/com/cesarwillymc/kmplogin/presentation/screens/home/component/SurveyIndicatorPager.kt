package com.cesarwillymc.kmplogin.presentation.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColor
import com.cesarwillymc.kmplogin.presentation.theme.TextColorOpacity
import com.cesarwillymc.kmplogin.presentation.theme.Typography
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.util.constants.FIVE
import com.cesarwillymc.kmplogin.util.constants.FRACTION_90
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by Cesar Canaza on 11/16/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SurveyContentPager(
    surveyItem: SurveyItem,
    currentItem: Int,
    totalItems: Int,
    modifier: Modifier = Modifier,
    navigateDetail: (SurveyItem) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy( DimensionManager.getPadding(PaddingType.Medium)),
        modifier = modifier
    ) {
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = DimensionManager.getPadding(PaddingType.Small)),
            horizontalArrangement = Arrangement.Start
        ) {
            repeat(totalItems) { iteration ->
                val color =
                    if (currentItem == iteration) Color.White else Color.Gray.copy(alpha = FRACTION_90)
                Box(
                    modifier = Modifier
                        .padding(FIVE.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(DimensionManager.getPadding(PaddingType.Large))
                )
            }
        }
        Text(text = surveyItem.title, style = Typography.titleMedium, color = TextColor)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = surveyItem.description,
                style = Typography.bodyLarge,
                color = TextColorOpacity
            )
            Image(
                painter = painterResource(SharedRes.images.arrow_ios_forward),
                contentDescription = "Icon go detail survey",
                modifier = Modifier
                    .clickable {
                        navigateDetail(surveyItem)
                    }
                    .padding(bottom =  DimensionManager.getPadding(PaddingType.Medium))
            )
        }
    }
}
