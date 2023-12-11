package com.cesarwillymc.kmplogin.presentation.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.ImageType
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColor
import com.cesarwillymc.kmplogin.presentation.theme.Typography
import com.cesarwillymc.kmplogin.presentation.theme.getImageSize
import com.cesarwillymc.kmplogin.presentation.theme.getPadding
import com.cesarwillymc.kmplogin.presentation.utils.DateFormat
import com.cesarwillymc.kmplogin.util.constants.PATTERN_DAY_MONTH_DAY
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun ProfileCard(openDrawer: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(top = DimensionManager.getPadding(PaddingType.Medium))
            .padding(horizontal = DimensionManager.getPadding(PaddingType.Medium)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(DimensionManager.getPadding(PaddingType.Medium))) {
            Text(
                text = DateFormat(PATTERN_DAY_MONTH_DAY).format(
                    Clock.System.now().toLocalDateTime(TimeZone.UTC)
                ).uppercase(),
                style = Typography.bodyMedium.copy(fontWeight = FontWeight.ExtraBold),
                color = TextColor
            )
            Text(
                text = stringResource(SharedRes.strings.lbl_today).uppercase(),
                style = Typography.titleLarge,
                color = TextColor
            )
        }
        Spacer(modifier = Modifier.size(DimensionManager.getPadding(PaddingType.Small)))

        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .clickable(onClick = openDrawer)
        ) {
            Image(
                painter = painterResource(SharedRes.images.profile),
                contentDescription = stringResource(SharedRes.strings.lbl_profile),
                modifier = Modifier.size(DimensionManager.getImageSize(ImageType.IconMedium)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
