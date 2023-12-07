import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.cesarwillymc.kmplogin.di.initKoin
import com.cesarwillymc.kmplogin.presentation.App
import com.cesarwillymc.kmplogin.presentation.navigation.RootComponent

fun MainViewController() = ComposeUIViewController {
    initKoin()
    val root = remember {
        RootComponent(DefaultComponentContext(LifecycleRegistry()))
    }
    App(root)
}
