package se.sass.kmmstarterpack.data.repositoryImp

import kotlinx.coroutines.flow.Flow
import se.sass.kmmstarterpack.data.apiCall
import se.sass.kmmstarterpack.data.ktor.ResponseModel
import se.sass.kmmstarterpack.domain.api.SampleAPIService
import se.sass.kmmstarterpack.domain.model.SampleModel
import se.sass.kmmstarterpack.domain.repository.SampleRepository

class SampleRepositoryImp(
    private val apiService: SampleAPIService
): SampleRepository {
    override fun getData(): Flow<ResponseModel<SampleModel>> = apiCall {
        apiService.getPost().cast()
    }
}