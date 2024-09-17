package se.sass.kmmstarterpack.presentation.ui.first

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import se.sass.kmmstarterpack.data.ktor.ResponseModel
import se.sass.kmmstarterpack.domain.model.SampleModel
import se.sass.kmmstarterpack.domain.repository.SampleRepository
import se.sass.kmmstarterpack.presentation.BaseViewModel

class FirstScreenViewModel(
    private val repo: SampleRepository
): BaseViewModel() {
    private val _uiState = MutableStateFlow<ResponseModel<SampleModel>>(ResponseModel.Idle())
    val uiState: StateFlow<ResponseModel<SampleModel>> = _uiState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            repo.getData().collect {
                _uiState.value = it
            }
        }
    }

    override fun clear() {
        super.clear()
    }
}