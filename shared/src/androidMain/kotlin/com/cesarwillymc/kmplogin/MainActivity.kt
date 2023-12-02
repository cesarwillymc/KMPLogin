package com.cesarwillymc.kmplogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
/**
 * Created by Cesar Canaza on 12/2/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}