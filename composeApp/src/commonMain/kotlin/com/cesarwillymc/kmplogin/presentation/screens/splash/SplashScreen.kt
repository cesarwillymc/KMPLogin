package com.cesarwillymc.kmplogin.presentation.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.cesarwillymc.kmplogin.SharedRes
import com.cesarwillymc.kmplogin.presentation.navigation.event.SplashNavEvent
import com.cesarwillymc.kmplogin.presentation.utils.rememberResponsive
import com.cesarwillymc.kmplogin.presentation.utils.viewModel.rememberViewModel
import com.cesarwillymc.kmplogin.util.constants.DELAY_1000
import com.cesarwillymc.kmplogin.util.constants.DELAY_1500
import com.cesarwillymc.kmplogin.util.constants.FRACTION_20
import com.cesarwillymc.kmplogin.util.constants.ONE_F
import com.cesarwillymc.kmplogin.util.constants.ZERO
import com.cesarwillymc.kmplogin.util.constants.ZERO_F
import dev.icerock.moko.resources.compose.painterResource

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SplashScreen(
    event: SplashNavEvent
) {
    val splashViewModel = rememberViewModel(SplashViewModel::class) {
        SplashViewModel()
    }
    val offsetState = remember { Animatable(ZERO_F) }
    val alphaState = remember { Animatable(ONE_F) }
    val responsive = rememberResponsive()
    val navigateHome by splashViewModel.navigateHome.collectAsState()
    LaunchedEffect(true) {
        offsetState.animateTo(
            targetValue = -responsive.heightR(FRACTION_20).value, // Adjust this value based on your layout
            animationSpec = tween(
                durationMillis = DELAY_1500.toInt(),
                easing = FastOutSlowInEasing
            )
        )
        alphaState.animateTo(
            targetValue = ZERO_F,
            animationSpec = tween(durationMillis = DELAY_1000.toInt())
        )
        if (navigateHome == true) {
            event.navigateToHome()
        } else {
            event.navigateToSignIn()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(SharedRes.images.img_backgroud),
            contentDescription = "Image Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

            Image(
                painterResource(SharedRes.images.logo),
                contentDescription = "Image Logo",
                modifier = Modifier. offset(y = offsetState.value.dp, x = ZERO.dp)
                .alpha(alpha = alphaState.value)
            )


    }
}
