package com.cesarwillymc.kmplogin.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cesarwillymc.kmplogin.R
import com.cesarwillymc.kmplogin.presentation.screens.home.component.HomeContent
import com.cesarwillymc.kmplogin.presentation.screens.home.component.HomeContentLoading
import com.cesarwillymc.kmplogin.presentation.screens.home.component.HomeDrawerContent
import com.cesarwillymc.kmplogin.presentation.screens.home.viewmodel.HomeViewModel
import com.cesarwillymc.kmplogin.presentation.composables.CustomFullScreenLoading
import com.cesarwillymc.kmplogin.presentation.composables.CustomLottieMessage
import com.cesarwillymc.kmplogin.presentation.navigation.event.HomeEvent
import com.cesarwillymc.kmplogin.presentation.theme.BackgroundColor
import kotlinx.coroutines.launch

/**
 * Created by Cesar Canaza on 10/10/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun HomeScreen(
    event: HomeEvent,
    homeViewModel: HomeViewModel
) {
    val homeUiState by homeViewModel.homeUiState.collectAsState()
    val authUiState by homeViewModel.authUiState.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = BackgroundColor) {
                HomeDrawerContent(
                    onLogoutClick = homeViewModel::logout
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when {
                homeUiState.isError -> CustomLottieMessage(
                    lottie = R.raw.animation_error,
                    title = stringResource(
                        id = R.string.lbl_error
                    ),
                    message = stringResource(id = R.string.desc_error)
                )

                homeUiState.isSuccess -> homeUiState.data?.let {
                    HomeContent(
                        surveyList = it,
                        navigateToDetail = event::navigateToDetail,
                        openDrawer = {
                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )
                }

                else -> HomeContentLoading()
            }
        }
    }
    CustomFullScreenLoading(authUiState.isLoading)
    LaunchedEffect(authUiState) {
        if (authUiState.isSuccess) {
            event.navigateToSignIn()
        }
    }
}
