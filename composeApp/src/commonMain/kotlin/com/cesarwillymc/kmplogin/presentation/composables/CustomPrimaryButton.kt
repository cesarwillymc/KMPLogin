package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.cesarwillymc.kmplogin.presentation.theme.ButtonBackground
import com.cesarwillymc.kmplogin.presentation.theme.DimensionManager
import com.cesarwillymc.kmplogin.presentation.theme.PaddingType
import com.cesarwillymc.kmplogin.presentation.theme.TextColorButton
import com.cesarwillymc.kmplogin.presentation.theme.getPadding

@Composable
fun CustomPrimaryButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    title: String,
    textColor: Color = TextColorButton,
    isEnabled: Boolean = true,
    backGroundColor: Color = ButtonBackground,
    onClick: () -> Unit
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = backGroundColor,
            contentColor = textColor,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        elevation = ButtonDefaults.buttonElevation()
    ) {
        Text(
            text = title,
            modifier =  Modifier
                .padding(DimensionManager.getPadding(PaddingType.Small)),
            textAlign = TextAlign.Center
        )
    }
}

