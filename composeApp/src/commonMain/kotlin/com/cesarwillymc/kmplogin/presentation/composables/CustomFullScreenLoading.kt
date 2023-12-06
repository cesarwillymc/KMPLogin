package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.cesarwillymc.kmplogin.presentation.utils.lottie.LottieHandler

@Composable
fun CustomFullScreenLoading(showLoading: Boolean = false) {
    if (showLoading) {
        Dialog(
            {},
            DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                LottieHandler.loadingFile()
            }
        }
    }
}
