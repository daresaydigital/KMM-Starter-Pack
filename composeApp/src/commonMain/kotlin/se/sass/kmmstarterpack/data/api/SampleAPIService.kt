package se.sass.kmmstarterpack.data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import se.sass.kmmstarterpack.data.dto.SampleDto
import se.sass.kmmstarterpack.data.ktor.BASE_URL
import se.sass.kmmstarterpack.domain.api.SampleAPIService

class SampleAPIServiceImp(
    private val client: HttpClient
): SampleAPIService {
    override suspend fun getPost(): SampleDto {
        return client.get(BASE_URL+"posts/1") {
            // TODO add header if needed
        }.body()
    }
}