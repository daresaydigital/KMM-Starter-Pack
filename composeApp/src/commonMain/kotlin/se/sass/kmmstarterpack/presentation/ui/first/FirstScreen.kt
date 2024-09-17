package se.sass.kmmstarterpack.presentation.ui.first

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import se.sass.kmmstarterpack.data.ktor.ResponseModel
import se.sass.kmmstarterpack.domain.model.SampleModel

@Composable
fun FirstScreen(
    viewModel: FirstScreenViewModel
) {
    val response = viewModel.uiState.collectAsState().value
    FirstScreen(response)
}

@Composable
private fun FirstScreen(
    uiState: ResponseModel<SampleModel>
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
            Text(uiState.data.body?:"-")
        }
    }
}