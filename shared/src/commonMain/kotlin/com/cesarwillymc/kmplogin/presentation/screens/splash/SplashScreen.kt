package com.cesarwillymc.kmplogin.presentation.screens.splash

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.cesarwillymc.kmplogin.R
import com.cesarwillymc.kmplogin.presentation.navigation.event.SplashEvent
import com.cesarwillymc.kmplogin.presentation.utils.animations.OvershootInterpolatorFactory
import com.cesarwillymc.kmplogin.presentation.utils.rememberResponsive
import com.cesarwillymc.kmplogin.util.constants.DELAY_2500
import com.cesarwillymc.kmplogin.util.constants.DELAY_3000
import com.cesarwillymc.kmplogin.util.constants.FRACTION_20
import com.cesarwillymc.kmplogin.util.constants.ONE_F
import com.cesarwillymc.kmplogin.util.constants.TWO_F
import com.cesarwillymc.kmplogin.util.constants.ZERO
import com.cesarwillymc.kmplogin.util.constants.ZERO_F
import com.cesarwillymc.kmplogin.util.extension.rememberResponsive
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Cesar Canaza on 11/15/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun SplashScreen(
    event: SplashEvent,
    splashViewModel: SplashViewModel
) {
    val offsetState = remember { androidx.compose.animation.core.Animatable(ZERO_F) }
    val alphaState = remember { androidx.compose.animation.core.Animatable(ONE_F) }
    LocalViewConfiguration.current.minimumTouchTargetSize
    val responsive = rememberResponsive()
    val navigateHome by splashViewModel.navigateHome.collectAsState()
    LaunchedEffect(true) {
        launch {
            offsetState.animateTo(
                targetValue = -responsive.heightR(FRACTION_20).value, // Adjust this value based on your layout
                animationSpec = tween(
                    durationMillis = DELAY_3000,
                    easing = {
                        OvershootInterpolatorFactory(TWO_F).getInterpolation(it)
                    }
                )
            )
        }
        launch {
            alphaState.animateTo(
                targetValue = ZERO_F,
                animationSpec = tween(durationMillis = DELAY_3000)
            )
        }
        delay(DELAY_2500)
        if (navigateHome ==true){
            event.navigateToHome()
        }else{
            event.navigateToSignIn()
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_backgroud),
            contentDescription = "Image Logo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Image Logo",
            modifier = Modifier
                .offset(y = offsetState.value.dp, x = ZERO.dp)
                .alpha(alpha = alphaState.value)
        )
    }
}
