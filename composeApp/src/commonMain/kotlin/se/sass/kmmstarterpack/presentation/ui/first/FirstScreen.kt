package se.sass.kmmstarterpack.presentation.ui.first

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import se.sass.kmmstarterpack.data.ktor.ResponseModel
import se.sass.kmmstarterpack.domain.model.SampleModel
import se.sass.kmmstarterpack.presentation.ui.second.SecondScreen

class FirstScreen: Screen {

    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<FirstScreenModel>()
        val response = screenModel.uiState.collectAsState().value
        val navigator = LocalNavigator.currentOrThrow

        FirstScreen(response) {
            navigator.push(SecondScreen(it))
        }
    }

    @Composable
    private fun FirstScreen(
        uiState: ResponseModel<SampleModel>,
        navigate: (title: String) -> Unit
    ) {
        when(uiState) {
            is ResponseModel.Idle -> {
                Text("Idle")
            }
            is ResponseModel.Error -> {
                Text(uiState.error.message?:"")
            }
            is ResponseModel.Loading -> {
                Text("Loading")
            }
            is ResponseModel.Data -> {
                Column {
                    Text(uiState.data.body?:"-")

                    Button(onClick = {
                        navigate.invoke(uiState.data.title?:"-")
                    }) {
                        Text("Click Me")
                    }
                }
            }
        }
    }

}
