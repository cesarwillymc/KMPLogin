package com.cesarwillymc.kmplogin.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.domain.usecase.survey.entities.SurveyItem
import com.cesarwillymc.kmplogin.presentation.composables.CustomPrimaryButton
import com.cesarwillymc.kmplogin.presentation.navigation.event.DetailNavEvent
import com.cesarwillymc.kmplogin.presentation.screens.home.viewmodel.DetailSurveyViewModel
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.ImageType
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColor
import com.cesarwillymc.kmplogin.presentation.theme.TextColorOpacity
import com.cesarwillymc.kmplogin.presentation.theme.Typography
import com.cesarwillymc.kmplogin.presentation.theme.getImageSize
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.rememberViewModel
import com.cesarwillymc.kmplogin.util.constants.FRACTION_30
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun DetailSurveyScreen(
    event: DetailNavEvent,
    detail: SurveyItem
) {
    val detailSurveyViewModel = rememberViewModel(DetailSurveyViewModel::class) {
        DetailSurveyViewModel(detail)
    }
    val detailSurveyUiState by detailSurveyViewModel.detailUiState.collectAsState()
    Scaffold { paddingValues ->
        val data = detailSurveyUiState.data
        if (data != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
            ) {
                KamelImage(
                    asyncPainterResource(data = data.coverImageUrl),
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(DimensionManager.getPadding(PaddingType.Medium))
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        DimensionManager.getPadding(
                            PaddingType.Medium
                        )
                    )
                ) {
                    Icon(
                        painter = painterResource(SharedRes.images.arrow_ios_back),
                        contentDescription = stringResource(SharedRes.strings.desc_back),
                        modifier = Modifier
                            .size(DimensionManager.getImageSize(ImageType.IconSmall))
                            .clickable(onClick = event::onBack),
                        tint = Color.White
                    )
                    Text(text = data.title, style = Typography.titleMedium, color = TextColor)

                    Text(
                        text = data.description,
                        style = Typography.bodyLarge,
                        color = TextColorOpacity
                    )
                }
                CustomPrimaryButton(
                    title = stringResource(SharedRes.strings.lbl_start_survey),
                    modifier = Modifier.align(Alignment.BottomEnd)

                ) {
                }
            }
        }
    }
}
