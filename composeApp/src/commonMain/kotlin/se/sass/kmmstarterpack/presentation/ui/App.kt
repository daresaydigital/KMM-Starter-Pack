package se.sass.kmmstarterpack.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import se.sass.kmmstarterpack.di.InjectionHelper
import se.sass.kmmstarterpack.presentation.ui.first.FirstScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController: NavHostController = rememberNavController()
        Scaffold{
            NavHost(
                navController = navController,
                startDestination = "first",
                modifier = Modifier
                    .fillMaxSize()
            ) {
                composable(route = "first") {
                    FirstScreen(InjectionHelper.firstScreenViewModel)
                }
            }
        }

    }
}