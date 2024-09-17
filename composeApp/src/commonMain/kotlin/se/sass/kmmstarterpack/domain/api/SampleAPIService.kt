package se.sass.kmmstarterpack.domain.api

import se.sass.kmmstarterpack.data.dto.SampleDto

interface SampleAPIService {
    suspend fun getPost(): SampleDto
}