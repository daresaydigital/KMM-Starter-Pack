package se.sass.kmmstarterpack.domain.repository

import kotlinx.coroutines.flow.Flow
import se.sass.kmmstarterpack.data.ktor.ResponseModel
import se.sass.kmmstarterpack.domain.model.SampleModel

interface SampleRepository {
    fun getData(): Flow<ResponseModel<SampleModel>>
}