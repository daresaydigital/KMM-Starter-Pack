package se.sass.kmmstarterpack.presentation.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview

import se.sass.kmmstarterpack.presentation.ui.first.FirstScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold{
            Navigator(
                screen = FirstScreen(),
                onBackPressed = { currentScreen ->
                    true
                }
            )
        }

    }
}