package se.sass.kmmstarterpack.presentation.ui.second

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

class SecondScreen(val title: String): Screen {
    @Composable
    override fun Content() {
        Text("We're at second Screen and title is $title")
    }
}