package se.sass.kmmstarterpack.presentation.ui.first

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.sass.kmmstarterpack.data.ktor.ResponseModel
import se.sass.kmmstarterpack.domain.model.SampleModel
import se.sass.kmmstarterpack.domain.repository.SampleRepository

class FirstScreenModel(
    private val repo: SampleRepository
): ScreenModel {
    private val _uiState = MutableStateFlow<ResponseModel<SampleModel>>(ResponseModel.Idle())
    val uiState: StateFlow<ResponseModel<SampleModel>> = _uiState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        screenModelScope.launch {
            repo.getData().collect {
                _uiState.value = it
            }
        }
    }

}