package com.cesarwillymc.kmplogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.retainedComponent
import com.cesarwillymc.kmplogin.di.initKoin
import com.cesarwillymc.kmplogin.presentation.App
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent
import org.koin.android.ext.koin.androidContext

/**
 * Created by Cesar Canaza on 12/2/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalDecomposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKoin {
            androidContext(applicationContext)
        }
        val root = retainedComponent { RootComponent(it) }
        setContent {
            App(root)
        }
    }
}