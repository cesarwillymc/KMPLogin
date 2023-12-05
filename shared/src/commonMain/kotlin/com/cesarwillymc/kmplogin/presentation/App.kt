package com.cesarwillymc.kmplogin.presentation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import com.cesarwillymc.kmplogin.presentation.navigation.graph.NavigationGraph
import com.cesarwillymc.kmplogin.presentation.theme.MBCGroupTheme

/**
 * Created by Cesar Canaza on 12/2/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun App(root: RootComponent) {
    MBCGroupTheme {
        val childStack by root.childStack.subscribeAsState()
        Box(modifier = Modifier.fillMaxSize()) {
            NavigationGraph(
                childStack = childStack
            )
        }
    }
}