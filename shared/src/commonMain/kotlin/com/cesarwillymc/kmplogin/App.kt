package com.cesarwillymc.kmplogin
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator

/**
 * Created by Cesar Canaza on 12/2/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 */
@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize().statusBarsPadding(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(Greeting().greet())
        }
    }
}